package kg.geektech.game.players;

public abstract class Witcher extends Hero {
    public Witcher(int health, int damage) {
        super(health, damage, SuperAbility.RESURRECTION);
    }

    @Override
    public void applySuperPower(Boss Thanos, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() <= 0) {
                heroes[i].setHealth(200);
                this.setHealth(0);
                System.out.println("Witcher activated SUPER");
            }
        }
    }
}