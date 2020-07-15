package machine;

import java.util.Scanner;


public class CoffeeMachine {
    public static void main(String[] args) {
        int water = 400;
        int milk = 540;
        int coffee = 120;
        int cups = 9;
        int money = 550;
        String action = "";
        boolean exit = false;
        Scanner scanner = new Scanner(System.in);

        while (!exit) {
            System.out.println();
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            action = scanner.next();

            switch (action) {
                case "exit":
                    exit = true;
                    break;

                case "remaining":
                    printMachineStatus(water, milk, coffee, cups, money);
                    break;

                case "buy":
                    System.out.println();
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");

                    String buyAction = scanner.next();
                    switch (buyAction) {
                        case "1":
                            if (water - 250 < 0) {
                                System.out.println("Sorry, not enough water!");
                                break;
                            }
                            if (coffee - 16 < 0) {
                                System.out.println("Sorry, not enough coffee beans!");
                                break;
                            }
                            if (cups - 1 < 0) {
                                System.out.println("Sorry, not enough disposable cups!");
                                break;
                            }
                            water -= 250;
                            coffee -= 16;
                            cups -= 1;
                            money += 4;
                            System.out.println("I have enough resources, making you a coffee!");
                            break;
                        case "2":
                            if (water - 350 < 0) {
                                System.out.println("Sorry, not enough water!");
                                break;
                            }
                            if (coffee - 20 < 0) {
                                System.out.println("Sorry, not enough coffee beans!");
                                break;
                            }
                            if (milk - 75 < 0) {
                                System.out.println("Sorry, not enough milk!");
                                break;
                            }
                            if (cups - 1 < 0) {
                                System.out.println("Sorry, not enough disposable cups!");
                                break;
                            }
                            water -= 350;
                            coffee -= 20;
                            milk -= 75;
                            cups -= 1;
                            money += 7;
                            System.out.println("I have enough resources, making you a coffee!");
                            break;
                        case "3":
                            if (water - 200 < 0) {
                                System.out.println("Sorry, not enough water!");
                                break;
                            }
                            if (coffee - 12 < 0) {
                                System.out.println("Sorry, not enough coffee beans!");
                                break;
                            }
                            if (milk - 100 < 0) {
                                System.out.println("Sorry, not enough milk!");
                                break;
                            }
                            if (cups - 1 < 0) {
                                System.out.println("Sorry, not enough disposable cups!");
                                break;
                            }
                            water -= 200;
                            coffee -= 12;
                            milk -= 100;
                            cups -= 1;
                            money += 6;
                            System.out.println("I have enough resources, making you a coffee!");
                            break;
                        case "back":
                            break;
                    }
                    break;

                case "fill":
                    System.out.println("Write how many ml of water do you want to add:");
                    water += scanner.nextInt();

                    System.out.println("Write how many ml of milk do you want to add:");
                    milk += scanner.nextInt();

                    System.out.println("Write how many grams of coffee beans do you want to add:");
                    coffee += scanner.nextInt();

                    System.out.println("Write how many disposable cups of coffee do you want to add:");
                    cups += scanner.nextInt();
                    break;

                case "take":
                    System.out.println("I gave you $" + money);
                    System.out.println();
                    money = 0;
                    break;
            }
        }
    }

    private static void printMachineStatus(int water, int milk, int coffee, int cups, int money) {
        System.out.println();
        System.out.println();
        System.out.println("The coffee machine has:");
        System.out.printf("%s of water", water);
        System.out.println();
        System.out.printf("%s of milk", milk);
        System.out.println();
        System.out.printf("%s of coffee beans", coffee);
        System.out.println();
        System.out.printf("%s of disposable cups", cups);
        System.out.println();
        System.out.printf( money == 0? "%s of money": "$%s of money", money);
        System.out.println();
        System.out.println();
    }

}

