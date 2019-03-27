package black.bracken.potion.character;

/**
 * @author BlackBracken
 */
public final class People implements Character {

    private final String name;

    private int hp;

    public People(String name) {
        this.name = name;
        this.hp = 100;
    }

    @Override
    public void attack(Character victim) {
        victim.damage(30);

        System.out.println(getName() + ": " + victim.getName() + "に30ダメージを与える(残りHP: " + victim.getHp() + ")");
    }

    @Override
    public void damage(int damage) {
        this.hp -= damage;
        if (this.hp < 0) this.hp = 0; // TODO: consider to overflow
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getHp() {
        return this.hp;
    }

}
