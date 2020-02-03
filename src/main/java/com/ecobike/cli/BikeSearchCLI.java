package com.ecobike.cli;

import com.ecobike.model.BikeQuery;
import com.ecobike.model.BikeType;

import java.util.Scanner;

/*
 * This class provides user interaction with
 * searching Bike objects and handles user input.
 */
public class BikeSearchCLI {

    //search menu
    private static final String SEARCH_MENU = "Please select the type of bike you search:\n" +
            "1 - FOLDING BIKE\n" +
            "2 - E-BIKE\n" +
            "3 - SPEEDELEC\n";

    //returns BikeQuery object with user defined parameters
    protected static BikeQuery createQueryBike(Scanner scanner) {
        displaySearchMenu();
        String choice = scanner.nextLine().trim();
        BikeQuery bikeQuery = null;
        boolean exit = false;
        while (!exit) {
            switch (choice) {
                case "1":
                    bikeQuery = createQueryFoldingBike(scanner);
                    exit = true;
                    break;
                case "2":
                case "3":
                    bikeQuery = createQueryElectricBike(scanner, choice);
                    exit = true;
                    break;
                default:
                    System.out.println("Unknown command, please try again.");
                    break;
            }
        }
        return bikeQuery;
    }

    private static BikeQuery createQueryFoldingBike(Scanner scanner) {
        BikeQuery bikeQuery = new BikeQuery();
        bikeQuery.setBikeType(BikeType.FOLDING);
        int counter = 0;
        while (counter < 7) {
            switch (counter) {
                case 0:
                    System.out.println("Please enter brand: ");
                    System.out.println("If you want to skip this position press 'Enter'.");
                    String input = scanner.nextLine().trim();
                    if (input.length() == 0) {
                        bikeQuery.setBrand(null);
                        counter++;
                        break;
                    }
                    bikeQuery.setBrand(input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase());
                    counter++;
                    break;
                case 1:
                    System.out.println("Please enter size of wheels (inch): ");
                    System.out.println("If you want to skip this position press 'Enter'.");
                    input = scanner.nextLine().trim();
                    if (isPositiveInteger(input)) {
                        bikeQuery.setSizeOfWheels(Integer.parseInt(input));
                        counter++;
                    } else if (input.length() == 0){
                        bikeQuery.setSizeOfWheels(null);
                        counter++;
                    } else {
                        displayInvalidNumberInputMessage();
                    }
                    break;
                case 2:
                    System.out.println("Please enter number of gears: ");
                    System.out.println("If you want to skip this position press 'Enter'.");
                    input = scanner.nextLine().trim();
                    if (isPositiveInteger(input)) {
                        bikeQuery.setNumberOfGears(Integer.parseInt(input));
                        counter++;
                    } else if (input.length() == 0) {
                        bikeQuery.setNumberOfGears(null);
                        counter++;
                    } else {
                        displayInvalidNumberInputMessage();
                    }
                    break;
                case 3:
                    System.out.println("Please enter weight (grams): ");
                    System.out.println("If you want to skip this position press 'Enter'.");
                    input = scanner.nextLine().trim();
                    if (isPositiveInteger(input)) {
                        bikeQuery.setWeight(Integer.parseInt(input));
                        counter++;
                    } else if (input.length() == 0) {
                        bikeQuery.setWeight(null);
                        counter++;
                    } else {
                        displayInvalidNumberInputMessage();
                    }
                    break;
                case 4:
                    System.out.println("Please enter head/tail lights option [y/n]: ");
                    System.out.println("If you want to skip this position press 'Enter'.");
                    input = scanner.nextLine().trim();
                    if (input.equals("y")) {
                        bikeQuery.setLightsPresent(true);
                        counter++;
                    } else if (input.equals("n")) {
                        bikeQuery.setLightsPresent(false);
                        counter++;
                    } else if (input.length() == 0) {
                        bikeQuery.setLightsPresent(null);
                        counter++;
                    } else {
                        System.out.println("Invalid input");
                    }
                    break;
                case 5:
                    System.out.println("Please enter color: ");
                    System.out.println("If you want to skip this position press 'Enter'.");
                    input = scanner.nextLine().trim();
                    if (input.length() == 0) {
                        bikeQuery.setColor(null);
                        counter++;
                        break;
                    }
                    bikeQuery.setColor(input);
                    counter++;
                    break;
                case 6:
                    System.out.println("Please enter price: ");
                    System.out.println("If you want to skip this position press 'Enter'.");
                    input = scanner.nextLine().trim();
                    if (isPositiveInteger(input)) {
                        bikeQuery.setPrice(Integer.parseInt(input));
                        counter++;
                    } else if (input.length() == 0){
                        bikeQuery.setPrice(null);
                        counter++;
                    } else {
                        displayInvalidNumberInputMessage();
                    }
                    break;
            }
        }
        return bikeQuery;
    }

    private static BikeQuery createQueryElectricBike(Scanner scanner, String choice) {
        BikeQuery bikeQuery = new BikeQuery();
        if (choice.equals("2")) {
            bikeQuery.setBikeType(BikeType.EBIKE);
        } else {
            bikeQuery.setBikeType(BikeType.SPEEDELEC);
        }
        int counter = 0;
        while (counter < 7) {
            switch (counter) {
                case 0:
                    System.out.println("Please enter brand (if you want to skip press 'Enter'): ");
                    System.out.println("If you want to skip this position press 'Enter'.");
                    String input = scanner.nextLine().trim();
                    if (input.length() == 0) {
                        bikeQuery.setBrand(null);
                        counter++;
                        break;
                    }
                    bikeQuery.setBrand(input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase());
                    counter++;
                    break;
                case 1:
                    System.out.println("Please max speed (km/h): ");
                    System.out.println("If you want to skip this position press 'Enter'.");
                    input = scanner.nextLine().trim();
                    if (isPositiveInteger(input)) {
                        bikeQuery.setMaxSpeed(Integer.parseInt(input));
                        counter++;
                    } else if (input.length() == 0){
                        bikeQuery.setMaxSpeed(null);
                        counter++;
                    } else {
                        displayInvalidNumberInputMessage();
                    }
                    break;
                case 2:
                    System.out.println("Please enter weight (grams): ");
                    System.out.println("If you want to skip this position press 'Enter'.");
                    input = scanner.nextLine().trim();
                    if (isPositiveInteger(input)) {
                        bikeQuery.setWeight(Integer.parseInt(input));
                        counter++;
                    } else if (input.length() == 0) {
                        bikeQuery.setWeight(null);
                        counter++;
                    } else {
                        displayInvalidNumberInputMessage();
                    }
                    break;
                case 3:
                    System.out.println("Please enter head/tail lights option [y/n]: ");
                    System.out.println("If you want to skip this position press 'Enter'.");
                    input = scanner.nextLine().trim();
                    if (input.equals("y")) {
                        bikeQuery.setLightsPresent(true);
                        counter++;
                    } else if (input.equals("n")) {
                        bikeQuery.setLightsPresent(false);
                        counter++;
                    } else if (input.length() == 0) {
                        bikeQuery.setLightsPresent(null);
                        counter++;
                    } else {
                        System.out.println("Invalid input");
                    }
                    break;
                case 4:
                    System.out.println("Please enter battery capacity (mAh): ");
                    System.out.println("If you want to skip this position press 'Enter'.");
                    input = scanner.nextLine().trim();
                    if (isPositiveInteger(input)) {
                        bikeQuery.setBatteryCapacity(Integer.parseInt(input));
                        counter++;
                    } else if (input.length() == 0) {
                        bikeQuery.setBatteryCapacity(null);
                        counter++;
                    } else {
                        displayInvalidNumberInputMessage();
                    }
                    break;
                case 5:
                    System.out.println("Please enter color: ");
                    System.out.println("If you want to skip this position press 'Enter'.");
                    input = scanner.nextLine().trim();
                    if (input.length() == 0) {
                        bikeQuery.setColor(null);
                        counter++;
                        break;
                    }
                    bikeQuery.setColor(input);
                    counter++;
                    break;
                case 6:
                    System.out.println("Please enter price: ");
                    System.out.println("If you want to skip this position press 'Enter'.");
                    input = scanner.nextLine().trim();
                    if (isPositiveInteger(input)) {
                        bikeQuery.setPrice(Integer.parseInt(input));
                        counter++;
                    } else if (input.length() == 0){
                        bikeQuery.setPrice(null);
                        counter++;
                    } else {
                        displayInvalidNumberInputMessage();
                    }
                    break;
            }
        }
        return bikeQuery;
    }

    // checks String for valid integer representation
    private static boolean isPositiveInteger(String input) {
        int res = 0;
        try {
            res = Integer.parseInt(input);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return res > 0;
    }

    private static void displaySearchMenu() {
        System.out.println(SEARCH_MENU);
    }

    private static void displayInvalidNumberInputMessage() {
        System.out.println("Invalid input, it must be positive integer.");
    }
}
