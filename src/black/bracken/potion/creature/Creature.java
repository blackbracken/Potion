package black.bracken.potion.creature;

/**
 * @author BlackBracken
 */
public interface Creature {

    String getName();

    void attack(Creature victim);

    int getHp();

    void damage(int damage);

    default boolean isAlive() {
        return getHp() > 0;
    }

}
