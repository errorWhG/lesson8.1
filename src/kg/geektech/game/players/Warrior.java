package kg.geektech.game.players;

import java.util.Random;

public class Warrior extends Hero {
    public Warrior(int health, int damage) {
        super(health, damage, SuperAbility.CRITICAL_DAMAGE);
    }

    @Override
    public void applySuperPower(Hero[] heroes, Boss Thanos) {
        Random random = new Random();
        int randomNum = random.nextInt(3) + 1;
        switch (randomNum) {
            case 1:
                setDamage(getDamage() * 2);
                System.out.println("Super of Warrior is activated on 2");
                break;
            case 2:
                setDamage(getDamage() * 3);
                System.out.println("Super of Warrior is activated on 3");
                break;
            case 3:
                setDamage(getDamage() * 4);
                System.out.println("Super of Warrior is activated on 4");
                break;
        }
    }

    @Override
    public void applySuperPower(Boss Thanos, Hero[] heroes) {

    }
}
