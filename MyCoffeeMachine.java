package machine;

import java.util.Scanner;

public class MyCoffeeMachine {
    int water = 400;
    int milk = 540;
    int coffee = 120;
    int cups = 9;
    int money = 550;
    MachineState machineState;

    public static void main(String[] args) {
        boolean exit = false;
        Scanner scanner = new Scanner(System.in);
        String action = "";

        MyCoffeeMachine coffeeMachine = new MyCoffeeMachine();

        while (!exit) {
            if (coffeeMachine.machineState == MachineState.CHOOSE_ACTION) {
                System.out.println("Write action (buy, fill, take, remaining, exit):");
            }
            action = scanner.next();

            switch (action) {
                case "exit":
                    exit = true;
                    break;

                default:
                    coffeeMachine.processAction(action);
            }
        }
    }

    public MyCoffeeMachine() {
        machineState = MachineState.CHOOSE_ACTION;
    }

    public void processAction(String action) {
        switch (machineState) {
            case CHOOSE_ACTION:
                switch (action) {
                    case "remaining":
                        printMachineStatus();
                        machineState = MachineState.CHOOSE_ACTION;
                        break;
                    case "take":
                        System.out.println("I gave you $" + money);
                        System.out.println();
                        money = 0;
                        machineState = MachineState.CHOOSE_ACTION;
                        break;
                    case "buy":
                        System.out.println();
                        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                        machineState = MachineState.CHOOSE_COFFEE;
                        break;

                    case "fill":
                        machineState = MachineState.FILL_WATER;
                        System.out.println("Write how many ml of water do you want to add:");
                        break;
                }
                break;
            case FILL_WATER:
                water += Integer.parseInt(action);
                System.out.println("Write how many ml of milk do you want to add:");
                machineState = MachineState.FILL_MILLK;
                break;
            case FILL_MILLK:
                milk += Integer.parseInt(action);
                System.out.println("Write how many grams of coffee beans do you want to add:");
                machineState = MachineState.FILL_COFFEE;
                break;
            case FILL_COFFEE:
                coffee += Integer.parseInt(action);
                System.out.println("Write how many disposable cups of coffee do you want to add:");
                machineState = MachineState.FILL_CUPS;
                break;
            case FILL_CUPS:
                cups += Integer.parseInt(action);
                machineState = MachineState.CHOOSE_ACTION;
                break;
            case CHOOSE_COFFEE:
                switch (action) {
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
                }
                machineState = MachineState.CHOOSE_ACTION;
        }
    }

    private void printMachineStatus() {
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
        System.out.printf(money == 0 ? "%s of money" : "$%s of money", money);
        System.out.println();
        System.out.println();
    }

}

enum MachineState {
    CHOOSE_ACTION, CHOOSE_COFFEE, FILL_WATER, FILL_MILLK, FILL_COFFEE, FILL_CUPS,
}
