package black.bracken.potion;

import black.bracken.potion.character.Character;
import black.bracken.potion.character.People;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * @author BlackBracken
 */
public class Main {

    public static void main(String[] args) {
        Queue<Character> characterQueue = new ArrayDeque<>(Arrays.asList(
                new People("ファースト"),
                new People("セカンド"))
        );

        while (characterQueue.parallelStream().filter(Character::isAlive).count() >= 2) {
            Character attacker = characterQueue.remove();
            Character victim = characterQueue.remove();

            attacker.attack(victim);

            if (victim.isAlive()) characterQueue.add(victim);
            if (attacker.isAlive()) characterQueue.add(attacker);
        }

        Character champion = characterQueue.poll();
        if (champion != null) {
            System.out.println(champion.getName() + "がチャンピオン / HP: " + champion.getHp());
        } else {
            // unreachable yet
            System.out.println("ゼンメツ");
        }
    }

}
