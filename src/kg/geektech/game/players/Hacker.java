package kg.geektech.game.players;

import kg.geektech.game.general.RPG_Game;

import java.util.Random;

public class Hacker extends Hero {
    public Hacker(int health, int damage) {
        super(health, damage, SuperAbility.HACKING);
    }

    @Override
    public void applySuperPower(Hero[] heroes, Boss thanos) {
        Random random = new Random();
        int countOfRandom = RPG_Game.countOfRound;
        int randomHero = random.nextInt(heroes.length);
        int takeHealth = random.nextInt(thanos.getDamage() - 10) + 10;
        thanos.setHealth(thanos.getHealth() - takeHealth);

        if (countOfRandom % 2 == 0 && heroes[randomHero].getHealth() > 0 && this.getHealth() > 0) {
            heroes[randomHero].setHealth(getHealth() + takeHealth);
            System.out.println("\tHacker: user SuperAbility for " + heroes[randomHero].getClass().getSimpleName() + " " + takeHealth);
        }
        countOfRandom++;
    }

    @Override
    public void applySuperPower(Boss Thanos, Hero[] heroes) {

    }
}
