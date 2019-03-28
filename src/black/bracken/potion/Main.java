package black.bracken.potion;

import black.bracken.potion.arena.Arena;
import black.bracken.potion.arena.ArenaProgress;
import black.bracken.potion.creature.People;

/**
 * @author BlackBracken
 */
public class Main {

    public static void main(String[] args) {
        var arena = new Arena(
                new People("ファースト"),
                new People("セカンド")
        );

        arena.hold();
        while (arena.getProgress() instanceof ArenaProgress.Running) {
            arena.proceed();
        }

        if (!(arena.getProgress() instanceof ArenaProgress.Finished)) {
            // unreachable
            throw new IllegalStateException();
        }

        var championOptional = ((ArenaProgress.Finished) arena.getProgress()).getChampion();

        championOptional.ifPresentOrElse(
                champion -> {
                    System.out.println(champion.getName() + "がチャンピオン / HP: " + champion.getHp());
                },
                () -> {
                    // unreachable yet
                    System.out.println("ゼンメツ");
                }
        );
    }

}
