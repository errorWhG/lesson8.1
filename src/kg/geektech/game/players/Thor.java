package kg.geektech.game.players;

import kg.geektech.game.general.RPG_Game;

import java.util.Random;

public class Thor extends Hero {
    public Thor(int health, int damage) {
        super(health, damage, SuperAbility.LIGHTNING);
    }

    @Override
    public void applySuperPower(Hero[] heroes, Boss Thanos) {

        Random random = new Random();
        boolean superOfThorIsTrue = random.nextBoolean();
        if (superOfThorIsTrue) {
            Thanos.setDamage(0);
            System.out.println();
        }else if (!(superOfThorIsTrue)) {
            Thanos.setDamage(Thanos.getDamage());
        }
    }

    @Override
    public void applySuperPower(Boss Thanos, Hero[] heroes) {

    }
}
