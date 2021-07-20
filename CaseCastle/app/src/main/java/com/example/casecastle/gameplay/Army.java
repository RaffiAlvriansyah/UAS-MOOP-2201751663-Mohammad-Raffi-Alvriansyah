package com.example.casecastle.gameplay;

public class Army {
    private String division;
    private int attack;
    private int skill;

    public Army(String division, int attack, int skill) {
        // TODO Auto-generated constructor stub
        this.division = division;
        this.attack = attack;
        this.skill = skill;
    }

    public int getAttack() {
        return attack;
    }

    public int getSkill() {
        return skill;
    }

    public String getDivision() {
        return this.division;
    }

    public void boostAttack() {
        this.attack += this.attack * 0.4;
    }

}
