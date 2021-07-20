package com.example.casecastle.gameplay;

public class Heroes {
    private String category;
    private int level;
    private int skill;
    private int initialSkill;

    public Heroes(String category, int level, int skill) {
        this.category = category;
        this.level = level;
        this.initialSkill = skill;
        this.skill = skill;
    }

    public String getCategory() {
        return this.category;
    }

    public int getLevel() {
        return level;
    }

    public int getSkill() {
        return skill;
    }

    public void boostSkill() {
        this.skill = (int) (this.initialSkill + (this.initialSkill * 0.2));
    }

    public void resetSkill() {
        this.skill = this.initialSkill;
    }
}
