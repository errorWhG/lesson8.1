package kg.geektech.game.players;

import java.util.Random;

public class Berserk extends Hero{
    public Berserk(int health, int damage) {
        super(health, damage, SuperAbility.SAVE_DAMAGE_AND_REVERT);
    }

    @Override
    public void applySuperPower(Hero[] heroes, Boss Thanos) {
        Random random = new Random();
        int giveDamage = random.nextInt(25) + 1;
        setDamage(getDamage() + giveDamage);
        System.out.println("Berserk: user SuperAbility");

    }

    @Override
    public void applySuperPower(Boss Thanos, Hero[] heroes) {

    }
}