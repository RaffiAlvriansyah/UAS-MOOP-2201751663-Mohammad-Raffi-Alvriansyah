package com.example.casecastle.gameplay;

import java.util.ArrayList;

public class Castle {
    private String skin;
    private ArrayList<Heroes> heroes;
    private ArrayList<Army> armies;

    private int archerCount = 0;
    private int catapultCount = 0;
    private int cavalryCount = 0;
    private int infantryCount = 0;

    public Castle(String skin) {
        this.skin = skin;
        heroes = new ArrayList<>();
        armies = new ArrayList<>();
    }

    public String getSkin() {
        return this.skin;
    }

    public int getBoost() {
        return 0;
    }

    public void addHero(Heroes hero) {
        this.heroes.add(hero);
    }

    public void addArmy(Army army) {
        this.armies.add(army);
    }

    public ArrayList<Heroes> getHeroes() {
        return heroes;
    }

    public ArrayList<Army> getArmies() {
        return armies;
    }

    public void setHeroes(ArrayList<Heroes> heroes) {
        this.heroes = heroes;
    }

    public void setArmies(ArrayList<Army> armies) {
        this.armies = armies;
    }

    public void initTroops() {
        double archerBoost = 0;
        double catapultBoost = 0;
        double cavalryBoost = 0;
        double infantryBoost = 0;
        for (Heroes hero : this.heroes) {
            if (hero instanceof HeroesArcher) archerBoost += 0.4;
            else if (hero instanceof HeroesCatapult) catapultBoost += 0.4;
            else if (hero instanceof HeroesCavalry) cavalryBoost += 0.4;
            else if (hero instanceof HeroesInfantry) infantryBoost += 0.4;
        }

        for (Army army : this.armies) {
            if (army instanceof ArmyArcher) archerCount++;
            else if (army instanceof ArmyCatapult) catapultCount++;
            else if (army instanceof ArmyCavalry) cavalryCount++;
            else if (army instanceof ArmyInfantry) infantryCount++;
        }

        this.archerCount += (int) (archerBoost * archerCount);
        this.catapultCount += (int) (catapultBoost * catapultCount);
        this.cavalryCount += (int) (cavalryBoost * cavalryCount);
        this.infantryCount += (int) (infantryBoost * infantryCount);
    }

    public int getArcherCount() {
        return archerCount;
    }

    public int getCatapultCount() {
        return catapultCount;
    }

    public int getCavalryCount() {
        return cavalryCount;
    }

    public int getInfantryCount() {
        return infantryCount;
    }
}

