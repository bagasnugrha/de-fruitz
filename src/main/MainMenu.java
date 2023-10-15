package main;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

import classes.*;

public class MainMenu {
    
    // global variable
    static double balance = 1000;

    static ArrayList<Fruit> fruits = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static Random randomizer = new Random();

    static void printMenu() {
        int inputChoose;
        boolean isContinue;

        do {
            System.out.println("=======================");
            System.out.printf("%15s\n", "De Fruitz");
            System.out.println("=======================");
            System.out.println("Balance: " +balance);
            System.out.println("-----------------------");
            System.out.println("1. Buy Fruit");
            System.out.println("2. Sell Fruit");
            System.out.println("3. View All Fruit");
            System.out.println("4. Exit Store");
            System.out.print(">> ");
            inputChoose = sc.nextInt(); sc.nextLine();

            switch (inputChoose) {
                case 1:
                    buyFruit();
                    break;

                case 2:
                    sellFruit();
                    break;

                case 3:
                    showFruits();
                    break;

                case 4:
                    System.exit(0);

                default:
                    System.out.println("Invalid input!");
                    break;
            }
            
            // ask user if they want to continue or not
            isContinue = isContinue("Do you want to continue? (y/n): ");
            
        } while (inputChoose != 4 && isContinue);
    }

    static void buyFruit() {
        String ID;
        String fruitType;
        int weight;

        int basePrice = randomizer.nextInt(51) + 50; // range 50 - 100

        do {
            System.out.print("Fruit type [Apple | Banana]: ");
            fruitType = sc.nextLine();
        } while (!(fruitType.equalsIgnoreCase("Apple") || fruitType.equalsIgnoreCase("Banana")));

        do {
            System.out.print(fruitType + " weight [50 - 500]: ");
            weight = sc.nextInt();  sc.nextLine();
        } while (!(weight >= 50 && weight <= 500));

        if (fruitType.equalsIgnoreCase("Apple")) {
            ID = String.format("%s%3d", "AP", randomizer.nextInt(1000));
            String variety;
            
            do {
                System.out.print("Apple variety [Fuji | Gala | Honeycrisp | Golden Delicious] (case sensitive): ");
                variety = sc.nextLine();
            } while (
                !( variety.equals("Fuji") ||
                variety.equals("Gala") ||
                variety.equals("Honeycrisp") ||
                variety.equals("Golden Delicious"))
            );

            Fruit fruit = new Apple(ID, weight, basePrice, variety); // create fruit object (apple type)
            fruits.add(fruit); // add fruit to array list

        } else if (fruitType.equalsIgnoreCase("Banana")) {
            ID = String.format("%s%3d", "BN", randomizer.nextInt(1000));
            String ripeness;

            do {
                System.out.print("Banana ripeness [Overripe | Semi-ripe | Ripe | Unripe] (case sensitive): ");
                ripeness = sc.nextLine();
            } while (
                !( ripeness.equals("Overripe") ||
                ripeness.equals("Semi-ripe") ||
                ripeness.equals("Ripe") ||
                ripeness.equals("Unripe"))
            );

            Fruit fruit = new Banana(ID, weight, basePrice, ripeness); // create fruit object (banana type)
            fruits.add(fruit); // add fruit to array list
        }
    }

    static void sellFruit() {
        if (fruits.isEmpty()) {
            System.out.println("Fruit is empty");
        } else {
            int indexSell;

            printFruits();
            do {
                System.out.printf("Sell index [1 - %d]: ", fruits.size());
                indexSell = sc.nextInt(); sc.nextLine();
            } while (!(indexSell >= 1 && indexSell <= fruits.size()));

            // success message
            System.out.println("Fruit sold for " + fruits.get(indexSell - 1).getPrice());

            // update balance
            balance += fruits.get(indexSell - 1).getPrice();

            // remove fruit from array list
            fruits.remove(indexSell - 1);
        }
    }
            

    static void showFruits() {
        if (fruits.isEmpty()) {
            System.out.println("Fruit is empty ");
        } else {
            printFruits();
        }
    }

    static void printFruits() {
        int listNumber = 1; // for numbering

        System.out.println("=========================================================================");
        System.out.printf("| %2s | %5s | %10s | %7s | %15s | %15s |\n", "No", "ID", "Type", "Weight", "Variety", "Ripeness");
        System.out.println("=========================================================================");
        for (Fruit fruit : fruits) {
            if (fruit instanceof Apple) {
                System.out.printf("| %2d %s", listNumber, ((Apple)fruit).toString());
                System.out.println("=========================================================================");
            } else if (fruit instanceof Banana) {
                System.out.printf("| %2d %s", listNumber, ((Banana)fruit).toString());
                System.out.println("=========================================================================");
            }
            listNumber++; // update number
        }
    }

    static boolean isContinue(String message) {
        String yesOrNo;

        do {
            System.out.print("\n\n" + message);
            yesOrNo = sc.nextLine();
        } while (!(yesOrNo.equalsIgnoreCase("y") || yesOrNo.equalsIgnoreCase("n")));

        System.out.println("\n");

        return yesOrNo.equalsIgnoreCase("y"); // input = "y" -> return true, "n" -> return false
    }

}