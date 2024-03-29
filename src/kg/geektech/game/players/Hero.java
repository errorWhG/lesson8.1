package kg.geektech.game.players;

public abstract class Hero extends GameEntity
        implements HavingSuperPower {
    private SuperAbility superAbility;

    public Hero(int health, int damage, SuperAbility superAbility) {
        super(health, damage);
        this.superAbility = superAbility;
    }

    public abstract void applySuperPower(Boss Thanos, Hero[] heroes);
}
