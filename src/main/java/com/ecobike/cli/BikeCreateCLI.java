package com.ecobike.cli;

import java.util.Scanner;

/*
 * This class provides user interaction with
 * creating Bike objects and handles user input
 */
public class BikeCreateCLI {

    //returns String representation of User input for creating FoldingBike object
    protected static String getUserInputFoldingBike(Scanner scanner) {
        String userInput = "FOLDING BIKE";
        int counter = 0;
        while (counter < 7) {
            switch (counter) {
                case 0:
                    System.out.println("Please enter brand: ");
                    String input = scanner.nextLine().trim();
                    if (input.length() == 0) {
                        displayEmptyInputMessage();
                        break;
                    }
                    userInput += input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase() + "; ";
                    counter++;
                    break;
                case 1:
                    System.out.println("Please enter size of wheels (inch): ");
                    input = scanner.nextLine().trim();
                    if (isPositiveInteger(input)) {
                        userInput += input + "; ";
                        counter++;
                    } else {
                        displayInvalidNumberInputMessage();
                    }
                    break;
                case 2:
                    System.out.println("Please enter number of gears: ");
                    input = scanner.nextLine().trim();
                    if (isPositiveInteger(input)) {
                        userInput += input + "; ";
                        counter++;
                    } else {
                        displayInvalidNumberInputMessage();
                    }
                    break;
                case 3:
                    System.out.println("Please enter weight (grams): ");
                    input = scanner.nextLine().trim();
                    if (isPositiveInteger(input)) {
                        userInput += input + "; ";
                        counter++;
                    } else {
                        displayInvalidNumberInputMessage();
                    }
                    break;
                case 4:
                    System.out.println("Please enter head/tail lights option [y/n]: ");
                    input = scanner.nextLine().trim();
                    if (input.equals("y")) {
                        userInput += "true; ";
                        counter++;
                    } else if (input.equals("n")) {
                        userInput += "false; ";
                        counter++;
                    } else {
                        System.out.println("Invalid input");
                    }
                    break;
                case 5:
                    System.out.println("Please enter color: ");
                    input = scanner.nextLine().trim();
                    if (input.length() == 0) {
                        displayEmptyInputMessage();
                        break;
                    }
                    userInput += input + "; ";
                    counter++;
                    break;
                case 6:
                    System.out.println("Please enter price: ");
                    input = scanner.nextLine().trim();
                    if (isPositiveInteger(input)) {
                        userInput += input;
                        counter++;
                    } else {
                        displayInvalidNumberInputMessage();
                    }
                    break;
            }
        }
        return userInput;
    }

    //returns String representation of User input for creating ElectricBike object
    protected static String getUserInputElectricBike(Scanner scanner, String choice) {
        System.out.println(choice);
        String userInput = choice.equals("3") ? "E-BIKE " : "SPEEDELEC ";
        int counter = 0;
        while (counter < 7) {
            switch (counter) {
                case 0:
                    System.out.println("Please enter brand: ");
                    String input = scanner.nextLine().trim();
                    if (input.length() == 0) {
                        displayEmptyInputMessage();
                        break;
                    }
                    userInput += input + "; ";
                    counter++;
                    break;
                case 1:
                    System.out.println("Please enter max speed (km/h): ");
                    input = scanner.nextLine().trim();
                    if (isPositiveInteger(input)) {
                        userInput += input + "; ";
                        counter++;
                    } else {
                        displayInvalidNumberInputMessage();
                    }
                    break;
                case 2:
                    System.out.println("Please enter weight (grams): ");
                    input = scanner.nextLine().trim();
                    if (isPositiveInteger(input)) {
                        userInput += input + "; ";
                        counter++;
                    } else {
                        displayInvalidNumberInputMessage();
                    }
                    break;
                case 3:
                    System.out.println("Please enter head/tail lights option [y/n]: ");
                    input = scanner.nextLine().trim();
                    if (input.equals("y")) {
                        userInput += "true; ";
                        counter++;
                    } else if (input.equals("n")) {
                        userInput += "false; ";
                        counter++;
                    } else {
                        System.out.println("Invalid input");
                    }
                case 4:
                    System.out.println("Please enter battery capacity (mAh): ");
                    input = scanner.nextLine().trim();
                    if (isPositiveInteger(input)) {
                        userInput += input + "; ";
                        counter++;
                    } else {
                        displayInvalidNumberInputMessage();
                    }
                    break;
                case 5:
                    System.out.println("Please enter color: ");
                    input = scanner.nextLine().trim();
                    if (input.length() == 0) {
                        displayEmptyInputMessage();
                        break;
                    }
                    userInput += input + "; ";
                    counter++;
                    break;
                case 6:
                    System.out.println("Please enter price (euro): ");
                    input = scanner.nextLine().trim();
                    if (isPositiveInteger(input)) {
                        userInput += input;
                        counter++;
                    } else {
                        displayInvalidNumberInputMessage();
                    }
                    break;
            }
        }
        return userInput;
    }

    private static boolean isPositiveInteger(String input) {
        int res = 0;
        try {
            res = Integer.parseInt(input);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return res > 0;
    }

    private static void displayInvalidNumberInputMessage() {
        System.out.println("Invalid input, it must be positive integer.");
    }

    private static void displayEmptyInputMessage() {
        System.out.println("Input can not be empty.");
    }
}
