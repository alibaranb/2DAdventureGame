package com.company;

public class Enemy {
    private int maxEnemyHealth;
    private int enemyDamage;
    private int enemyHealth;
    private String[] enemies;

    public int getMaxEnemyHealth() {
        return maxEnemyHealth;
    }

    public void setMaxEnemyHealth(int maxEnemyHealth) {
        this.maxEnemyHealth = maxEnemyHealth;
    }

    public int getEnemyDamage() {
        return enemyDamage;
    }

    public void setEnemyDamage(int enemyDamage) {
        this.enemyDamage = enemyDamage;
    }

    public int getEnemyHealth() {
        return enemyHealth;
    }

    public void setEnemyHealth(int enemyHealth) {
        this.enemyHealth = enemyHealth;
    }

    public String[] getEnemies() {
        return enemies;
    }

    public void setEnemies(String[] enemies) {
        this.enemies = enemies;
    }
}
