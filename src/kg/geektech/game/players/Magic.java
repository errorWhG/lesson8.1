package kg.geektech.game.players;

import java.util.Random;

public class Magic extends Hero {
    public Magic(int health, int damage) {
        super(health, damage, SuperAbility.BOOST);
    }

    @Override
    public void applySuperPower(Hero[] heroes, Boss Thanos) {
        Random random = new Random();
        int giveDamage = random.nextInt(25) + 1;
        for (int i = 0; i < heroes.length; i++) {
            heroes[i].setDamage(getDamage() + giveDamage);

        }
        System.out.println("Magic: user SuperAbility");
    }

    @Override
    public void applySuperPower(Boss Thanos, Hero[] heroes) {

    }
}
