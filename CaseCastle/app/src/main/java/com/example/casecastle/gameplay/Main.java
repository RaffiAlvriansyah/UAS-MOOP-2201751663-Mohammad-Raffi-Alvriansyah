package com.example.casecastle.gameplay;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    Scanner scan = new Scanner(System.in);
    ArrayList<Player> aPlayer = new ArrayList<>();
    Player Player = new Player();

    public Main() {
        System.out.println("====WAR==GAMES====");
        System.out.println("                  ");
        ArrayList<Heroes> aHeroA = new ArrayList<>();
        aHeroA.add(new HeroesCavalry("Cavalry", 50, 100));
        aHeroA.add(new HeroesInfantry("Infantry", 50, 100));
        aHeroA.add(new HeroesArcher("Archer", 50, 100));

        ArrayList<Army> aArmyA = new ArrayList<>();
        aArmyA.add(new ArmyArcher("Archer", 100, 100));
        aArmyA.add(new ArmyArcher("Archer", 100, 100));
        aArmyA.add(new ArmyArcher("Archer", 100, 100));
        aArmyA.add(new ArmyCavalry("Cavalry", 100, 100));
        aArmyA.add(new ArmyCavalry("Cavalry", 100, 100));
        aArmyA.add(new ArmyInfantry("Infantry", 100, 100));
        aArmyA.add(new ArmyInfantry("Infantry", 100, 100));
        aArmyA.add(new ArmyInfantry("Infantry", 100, 100));
        aArmyA.add(new ArmyCatapult("Catapult", 100, 100));
        aArmyA.add(new ArmyCatapult("Catapult", 100, 100));

        ArrayList<Heroes> aHeroB = new ArrayList<>();
        aHeroB.add(new HeroesCavalry("Cavalry", 43, 100));
        aHeroB.add(new HeroesInfantry("Infantry", 43, 100));

        ArrayList<Army> aArmyB = new ArrayList<>();
        aArmyB.add(new ArmyCavalry("Cavalry", 100, 100));
        aArmyB.add(new ArmyCatapult("Catapult", 100, 100));
        aArmyB.add(new ArmyInfantry("Infantry", 100, 100));

        aPlayer.add(new Player("Player A", new CastleSteel("Steel"), aHeroA, aArmyA));
        aPlayer.add(new Player("Player B", new CastleSteel("Steel"), aHeroB, aArmyB));
        boolean isRunning = true;

        do {
            System.out.println("Menu War Games");
            System.out.println("1. View Stats Player");
            System.out.println("2. Change Castle Skin");
            System.out.print("Insert your choice: ");
            int choice = scan.nextInt();

            if (choice == 1) {

                System.out.println("War Games");
                System.out.println("=========================");

                int total = 0;

                for (Player player : aPlayer) {
                    System.out.println("Name : " + player.getName());
                    System.out.println("Castle Skin" + ": " + player.getCastle().getSkin());
                    System.out.println("Heroes : " + player.getHeroes().size());
                    for (Heroes hero : player.getHeroes()) {
                        System.out.println("Hero: " + "leader of " + hero.getCategory() + " Army" + " Level : " + hero.getLevel());
                        System.out.println("Skill: " + hero.getSkill());
                    }
                    System.out.println("Armies : " + player.getArmies().size());
                    for (Army Armies : player.getArmies()) {
                        System.out.println("Army Division: " + Armies.getDivision());
                        System.out.println("Attack: " + Armies.getAttack());
                    }
                    System.out.println("===========================");
                }
            } else if (choice == 2) {
                int playerOrder = 1;
                for (Player player : aPlayer) {
                    System.out.println(playerOrder + ". " + player.getName());
                    playerOrder++;
                }
                System.out.print("Insert option: ");
                int indexPlayer = scan.nextInt() - 1;
                if (indexPlayer < aPlayer.size() && indexPlayer >= 0) {
                    Player player = aPlayer.get(indexPlayer);
                    System.out.println("Which new skin will be used?");
                    System.out.println("1. Horse Skin");
                    System.out.println("2. Wood Skin");
                    System.out.println("3. Steel Skin");
                    System.out.println("4. Stone Skin");
                    System.out.print("Insert option: ");
                    int skinIndex = scan.nextInt();
                    if (skinIndex == 1) {
                        player.setCastle(new CastleHorse("Horse"));
                    } else if (skinIndex == 2) {
                        player.setCastle(new CastleWood("Wood"));
                    } else if (skinIndex == 3) {
                        player.setCastle(new CastleSteel("Steel"));
                    } else if (skinIndex == 4) {
                        player.setCastle(new CastleStone("Stone"));
                    } else {
                        System.out.println("Skin is not available.");
                    }
                } else {
                    System.out.println("Player not found.");
                }
            } else if (choice == 3) {
                System.out.println("You will be logged out.");
                isRunning = false;
            } else {
                System.out.println("Menu is not available.");
            }
        } while (isRunning);
    }


    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new Main();

    }

}
