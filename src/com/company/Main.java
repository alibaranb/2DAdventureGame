package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Random rand = new Random();


        Player player = new Player();
        Enemy enemy = new Enemy();

        //PLAYER INFORMATION
        player.setHealth(100);
        player.setAttackDamage(30);
        player.setHPDropChance(40);
        player.setHPHealAmount(30);
        player.setHPLeft(3);
        player.setMoney(0);
        player.setY(0);
        player.setX(0);
        player.setTotalKill(0);

        //ASSIGN
        int playerHealth = player.getHealth();
        int money = player.getMoney();

        //ENEMY INFORMATION
        String[] enemies = new String[]{"Bear", "Wolf"};
        enemy.setEnemies(enemies);
        enemy.setEnemyDamage(25);
        enemy.setMaxEnemyHealth(30);

        boolean moving = true;
        System.out.println("Welcome to the world!");

        //GAME
        while (moving) {
            System.out.println("--------------------------------------------");

            player.playerMove();

            int moneyChance = rand.nextInt(100);

            int enemyChance = rand.nextInt(100);
            int enemyHealth = 0;
            String enemyRandomed;

            if (enemyChance < 34) {
                enemyHealth = rand.nextInt(enemy.getMaxEnemyHealth());
                enemyRandomed = enemies[rand.nextInt(enemies.length)];
                System.out.println("\t# " + enemyRandomed + " has appeared! #\n");

                // BATTLE
                while (enemyHealth > 0) {
                    //MAIN MENU
                    System.out.println("\tYour location (x,y) : " + player.getX() + "," + player.getY());
                    System.out.println("\tYour total kill : " + player.getTotalKill());
                    System.out.println("\tHealth potion(s) : " + player.getHPLeft());
                    System.out.println("\tYour HP: " + playerHealth);
                    System.out.println("\t" + enemyRandomed + "'s HP: " + enemyHealth);
                    System.out.println("\n\tWhat would you like to do?");
                    System.out.println("\t1. Attack");
                    System.out.println("\t2. Drink health potion");
                    System.out.println("\t3. Run!");
                    System.out.println("\n\t-# SHOP #-");
                    System.out.println("\t# You have " + money + " money #");
                    System.out.println("\t4. Upgrade your sword (+5 Damage) - 15$");
                    System.out.println("\t5. Upgrade your armor (Enemies will deal -5 less damage to you) - 20$");

                    String input2 = in.nextLine();

                    //CHOICES

                    // ATTACK
                    if (input2.equals("1")) {
                        int damageDealt = rand.nextInt(player.getAttackDamage());
                        int damageTaken = rand.nextInt(enemy.getEnemyDamage());

                        enemyHealth -= damageDealt;
                        playerHealth -= damageTaken;


                        System.out.println("\t> You strike the " + enemyRandomed + " for " + damageDealt + " damage.");
                        System.out.println("\t> You received " + damageTaken + " from the " + enemyRandomed);

                        if (playerHealth < 1) {
                            System.out.println("\nYou are too weak to continue the fight.");
                            moving = false;
                        } else if (enemyHealth < 1) {
                            player.setTotalKill(player.getTotalKill() + 1);
                            money += 5;
                            System.out.println("\t> You have earned 5 money!");
                        }
                    }

                    // Health Potion
                    else if (input2.equals("2")) {
                        if (player.getHPLeft() > 0) {
                            playerHealth += player.getHPHealAmount();
                            player.setHPLeft(player.getHPLeft() - 1);
                            System.out.println("\t> You drink a health potion, healing yourself for " + player.getHPHealAmount()
                                    + "\n\t> You now have " + playerHealth + " HP."
                                    + "\n\t> You have " + player.getHPLeft() + " health potions left.\n");
                        } else {
                            System.out.println("You don't have any health potion left.");
                        }
                    }

                    // RUN
                    else if (input2.equals("3")) {
                        System.out.println("\tYou run away from the " + enemyRandomed + "!");

                        player.playerMove();

                        enemyHealth = rand.nextInt(enemy.getMaxEnemyHealth());
                        enemyRandomed = enemies[rand.nextInt(enemies.length)];
                        System.out.println("\t# " + enemyRandomed + " has appeared! #\n");
                    }

                    // SHOP
                    else if (input2.equals("4")) {
                        if (money >= 15) {
                            money -= 15;
                            player.setAttackDamage(player.getAttackDamage() + 5);
                            System.out.println("\t> You have unlocked an upgrade and increased your attack damage for 5!\n");
                        } else {
                            System.out.println("\t>The price of the upgrade is 15$. Make sure you have 15 or more dollars!\n");
                        }
                    } else if (input2.equals("5")) {
                        if (money >= 20) {
                            money -= 20;
                            enemy.setEnemyDamage(enemy.getEnemyDamage() - 5);
                            System.out.println("\t> You have unlocked an upgrade and upgraded your armor's durability!\n");
                        } else {
                            System.out.println("\t>The price of the upgrade is 20$. Make sure you have 20 or more dollars!\n");
                        }
                    } else {
                        System.out.println("\tInvalid command!");
                    }
                }


                if (playerHealth > 1) {
                    System.out.println("--------------------------------------------");
                    System.out.println(" # " + enemyRandomed + " was defeated! # ");
                    System.out.println(" # You have " + playerHealth + " HP left # ");

                    //Health Potion Drop System
                    if (rand.nextInt(100) < player.getHPDropChance()) {
                        player.setHPLeft(player.getHPLeft() + 1);
                        System.out.println(" # The " + enemyRandomed + " dropped a health potion! # ");
                        System.out.println(" # You now have " + player.getHPLeft() + " health potion(s). # ");
                    }
                }

                // WIN
                if (player.getTotalKill() == 5) {
                    System.out.println("\nCongratulations! You won the game!");
                    System.out.println("###########################");
                    System.out.println("### THANKS FOR PLAYING! ###");
                    System.out.println("# CREDITS : ALI BAYRAMBEY #");
                    System.out.println("###########################");
                    moving = false;
                } else {
                    System.out.println("--------------------------------------------");
                    System.out.println("What would you like to do now?");
                    System.out.println("1. Continue fighting?");
                    System.out.println("2. Exit the game");

                    String input = in.nextLine();

                    while (!input.equals("1") && !input.equals("2")) {
                        System.out.println("Invalid command!");
                        input = in.nextLine();
                    }

                    if (input.equals("1") && playerHealth > 1) {
                        System.out.println("You continue on your adventure!");
                    } else if (input.equals("2") || playerHealth < 1) {
                        System.out.println("You stopped walking and decided to sleep.\n");
                        moving = false;
                        System.out.println("###########################");
                        System.out.println("### THANKS FOR PLAYING! ###");
                        System.out.println("# CREDITS : ALI BAYRAMBEY #");
                        System.out.println("###########################");
                    }
                }
            }
            // MONEY DROP SYSTEM
            else if (moneyChance < 25) {
                money += 5;
                System.out.println("You have found 5$ on ground!");
            }

            // IF PLAYER DIDN'T FACE WITH AN ENEMY
            else {
                System.out.println("\t>This coordinate is empty.");
            }
        }
    }
}
