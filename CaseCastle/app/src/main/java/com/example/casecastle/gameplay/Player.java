package com.example.casecastle.gameplay;

import java.util.ArrayList;
    public class Player {
        private String name;
        private Castle castle;
        private ArrayList<Heroes> heroes;
        private ArrayList<Army> armies;

        public Player(String name, Castle castle, ArrayList<Heroes> heroes, ArrayList<Army> armies) {
            this.name = name;
            this.castle = castle;
            this.heroes = heroes;
            this.armies = armies;

            boostAttack();
            boostSkill();
        }

        public Player() {
            // TODO Auto-generated constructor stub
        }

        public String getName() {
            return this.name;
        }

        public Castle getCastle() {
            return this.castle;
        }

        public ArrayList<Heroes> getHeroes() {
            return this.heroes;
        }

        public ArrayList<Army> getArmies() {
            return this.armies;
        }

        public void setCastle(Castle castle) {
            this.castle = castle;
            boostSkill();
        }

        public void setHeroes(ArrayList<Heroes> heroes) {
            this.heroes = heroes;
            boostAttack();
        }

        private void boostSkill() {
            if (this.castle instanceof CastleHorse) {
                for (Heroes heroes : heroes) {
                    if (heroes instanceof HeroesCavalry) {
                        heroes.boostSkill();
                    } else {
                        heroes.resetSkill();
                    }
                }
            } else if (this.castle instanceof CastleWood) {
                for (Heroes heroes : heroes) {
                    if (heroes instanceof HeroesArcher) {
                        heroes.boostSkill();
                    } else {
                        heroes.resetSkill();
                    }
                }
            } else if (this.castle instanceof CastleSteel) {
                for (Heroes heroes : heroes) {
                    if (heroes instanceof HeroesInfantry) {
                        heroes.boostSkill();
                    } else {
                        heroes.resetSkill();
                    }
                }
            } else if (this.castle instanceof CastleStone) {
                for (Heroes heroes : heroes) {
                    if (heroes instanceof HeroesCatapult) {
                        heroes.boostSkill();
                    } else {
                        heroes.resetSkill();
                    }
                }
            }
        }

        private void boostAttack() {
            for (Heroes hero : heroes) {
                if (hero instanceof HeroesInfantry) {
                    for (Army army : armies) {
                        if (army instanceof ArmyInfantry) {
                            army.boostAttack();
                        }
                    }
                } else if (hero instanceof HeroesCavalry) {
                    for (Army army : armies) {
                        if (army instanceof ArmyCavalry) {
                            army.boostAttack();
                        }
                    }
                } else if (hero instanceof HeroesArcher) {
                    for (Army army : armies) {
                        if (army instanceof ArmyArcher) {
                            army.boostAttack();
                        }
                    }
                } else if (hero instanceof HeroesCatapult) {
                    for (Army army : armies) {
                        if (army instanceof ArmyCatapult) {
                            army.boostAttack();
                        }
                    }
                }
            }
        }

    }
