package black.bracken.potion.character;

/**
 * @author BlackBracken
 */
public interface Character {

    String getName();

    void attack(Character victim);

    int getHp();

    void damage(int damage);

    default boolean isAlive() {
        return getHp() > 0;
    }

}
