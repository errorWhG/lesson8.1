package kg.geektech.game.general;

import kg.geektech.game.players.*;

import java.util.Scanner;

public class RPG_Game {

    public static int countOfRound = 0;

    public static void start() {

        Boss Thanos = new Boss(1000, 50);

        Warrior warrior = new Warrior(290, 15);
        Medic doc = new Medic(200, 5, 15);
        Magic magic = new Magic(270, 20);
        Berserk berserk = new Berserk(240, 20);
        Medic assistant = new Medic(280, 10, 5);
        Hacker hacker = new Hacker(260, 20);
        Thor thor = new Thor(300, 25);
        Witcher witcher = new Witcher(250, 0) {
            @Override
            public void applySuperPower(Hero[] heroes, Boss Thanos) {
            }
        };

        Hero[] heroes = {warrior, doc, magic, berserk, assistant, thor,  witcher, hacker};
        printStatistics(heroes, Thanos);

        while (!isGameFinished(heroes, Thanos)) {
            round(heroes, berserk, Thanos, doc, warrior, magic,
                    assistant, thor,  witcher, hacker);
        }
    }

    private static void round(Hero[] heroes, Berserk berserk, Boss Thanos, Medic doc,
                              Warrior warrior, Magic magic, Medic assistant, Thor thor,
                               Witcher witcher, Hacker hacker) {
        bossHits(heroes, Thanos);
        heroesHit(heroes, Thanos);
        applySuperPowers(heroes, Thanos);
        printStatistics(heroes, Thanos);
        allHeroesIsBack(berserk, doc, warrior, magic, assistant, thor,  witcher, hacker);
        damageOfThanosIsBack(Thanos);
    }
    public static void damageOfThanosIsBack(Boss Thanos){
        Thanos.setDamage(50);
    }


    public static void allHeroesIsBack(Berserk berserk, Medic doc, Warrior warrior,
                                       Magic magic, Medic assistant, Thor thor,
                                        Witcher witcher, Hacker hacker) {
        magic.setDamage(20);
        doc.setDamage(5);
        warrior.setDamage(15);
        assistant.setDamage(10);
        berserk.setDamage(20);
        thor.setDamage(25);
        witcher.setDamage(0);
        hacker.setDamage(20);
    }

    private static void bossHits(Hero[] heroes, Boss Thanos) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && Thanos.getHealth() > 0) {
                heroes[i].setHealth(
                        heroes[i].getHealth() - Thanos.getDamage());
            }
        }
    }

    private static void applySuperPowers(Hero[] heroes, Boss Thanos) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && Thanos.getHealth() > 0) {
                heroes[i].applySuperPower(heroes, Thanos);
            }
        }
    }

    private static void heroesHit(Hero[] heroes, Boss Thanos) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && Thanos.getHealth() > 0) {
                Thanos.setHealth(
                        Thanos.getHealth() - heroes[i].getDamage());
            }
        }
    }

    private static boolean isGameFinished(Hero[] heroes, Boss Thanos) {
        if (Thanos.getHealth() <= 0) {
            System.out.println("Heroes won!!!");
            return true;
        }
        boolean allHeroesDead = true;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead) {
            System.out.println("Thanos won!!!");
        }
        return allHeroesDead;
    }

    private static void printStatistics(Hero[] heroes, Boss Thanos) {
        System.out.println("______________");
        System.out.println("\t\tROUND #" + ++countOfRound);
        System.out.println("Boss health: " + Thanos.getHealth() +
                " [" + Thanos.getDamage() + "]");
        for (int i = 0; i < heroes.length; i++) {
            System.out.println(heroes[i].getClass().getSimpleName() + " health: "
                    + heroes[i].getHealth() +
                    " [" + heroes[i].getDamage() + "]");
        }
        System.out.println("______________");
    }

    public static void startGame() {
    }
}
