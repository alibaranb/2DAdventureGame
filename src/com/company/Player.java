package com.company;

import java.util.Scanner;

public class Player {
    private int health;
    private int attackDamage;
    private int HPLeft;
    private int HPHealAmount;
    private int HPDropChance;
    private int money;
    private int y;
    private int x;
    private int totalKill;

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public void setAttackDamage(int attackDamage) {
        this.attackDamage = attackDamage;
    }

    public int getHPLeft() {
        return HPLeft;
    }

    public void setHPLeft(int HPLeft) {
        this.HPLeft = HPLeft;
    }

    public int getHPHealAmount() {
        return HPHealAmount;
    }

    public void setHPHealAmount(int HPHealAmount) {
        this.HPHealAmount = HPHealAmount;
    }

    public int getHPDropChance() {
        return HPDropChance;
    }

    public void setHPDropChance(int HPDropChance) {
        this.HPDropChance = HPDropChance;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getTotalKill() {
        return totalKill;
    }

    public void setTotalKill(int totalKill) {
        this.totalKill = totalKill;
    }

    public void playerMove() {
        // MOVEMENT
        System.out.println("\nDirections : N, NE, E, SE, S, SW, W, NW");
        System.out.println("\tWhere do you want to go?");
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

        switch (input) {
            case "N" -> y += 1;
            case "NE" -> {
                y += 1;
                x += 1;
            }
            case "E" -> x += 1;
            case "SE" -> {
                y -= 1;
                x += 1;
            }
            case "S" -> y -= 1;
            case "SW" -> {
                y -= 1;
                x -= 1;
            }
            case "W" -> x -= 1;
            case "NW" -> {
                x -= 1;
                y -= 1;
            }
            default -> System.out.println("Direction is wrong. Make sure you have written it correctly.");
        }
    }
}
