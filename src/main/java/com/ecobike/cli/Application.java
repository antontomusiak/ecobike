package com.ecobike.cli;

import com.ecobike.dao.BikeRepository;
import com.ecobike.dao.BikeRepositoryImpl;
import com.ecobike.model.Bike;
import com.ecobike.model.BikeQuery;
import com.ecobike.utils.Utils;

import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * This class provides user interaction with
 * main menu and handles user input
 */
public class Application {

    //main menu
    private final String MENU = "Please make your choice:\n" +
            "1 - Show the entire EcoBike catalog\n" +
            "2 – Add a new folding bike\n" +
            "3 – Add a new speedelec\n" +
            "4 – Add a new e-bike\n" +
            "5 – Find the first item of a particular brand\n" +
            "6 – Write to file\n" +
            "7 – Stop the program\n";


    private final Scanner in;
    private final PrintStream out;
    private BikeRepository bikeRepository;
    private List<Bike> bikes = new ArrayList<>();

    public Application(Scanner in, PrintStream out) {
        this.in = in;
        this.out = out;
    }

    public void run() throws Exception {
        String fileName = "";
        System.out.print("Input File Name: ");
        boolean fileFound = false;
        while (!fileFound) {
            fileName = in.nextLine().trim();
            try {
                bikeRepository = new BikeRepositoryImpl(fileName);
                bikeRepository.getAll();
                fileFound = true;
            } catch (IOException e) {
                System.out.println("File not found, please try again.");
                System.out.print("Input File Name: ");
            }
        }
        boolean exit = false;
        displayMainMenu();
        while (!exit) {
            String command = in.nextLine().trim();
            switch (command) {
                case "menu":
                    displayMainMenu();
                    displayNextCommandMessage();
                    break;
                case "1":
                    List<Bike> bikes = bikeRepository.getAll();
                    displayBikeList(bikes, in);
                    displayNextCommandMessage();
                    break;
                case "2":
                    String userInput = BikeCreateCLI.getUserInputFoldingBike(in);
                    Bike bike = Utils.createBike(userInput);
                    bikeRepository.add(bike);
                    displayEntrySavedMessage();
                    displayNextCommandMessage();
                    break;
                case "3":
                case "4":
                    userInput = BikeCreateCLI.getUserInputElectricBike(in, command);
                    bike = Utils.createBike(userInput);
                    bikeRepository.add(bike);
                    displayEntrySavedMessage();
                    displayNextCommandMessage();
                    break;
                case "5":
                    BikeQuery bikeQuery = BikeSearchCLI.createQueryBike(in);
                    Bike b2 = bikeRepository.find(bikeQuery);
                    if (b2 == null) {
                        System.out.println("No match found");
                        break;
                    }
                    System.out.println(b2.toString());
                    displayNextCommandMessage();
                    break;
                case "6":
                    if (bikeRepository.hasUnsaved()) {
                        bikeRepository.saveAll();
                        displaySavedToFileMessage();
                    } else {
                        System.out.println("You don't have unsaved data.");
                    }
                    displayNextCommandMessage();
                    break;
                case "7":
                    exit = true;
                    break;
                default:
                    displayUnknownCommandMessage();
                    break;
            }
        }
        if (bikeRepository.hasUnsaved()) {
            System.out.println("There are unsaved changes.");
            System.out.println("Would you like to save changes to file? [y/n]");
            String input = in.nextLine().trim();
            if (input.equals("y")) {
                bikeRepository.saveAll();
                displaySavedToFileMessage();
            }
        }
        System.out.println("Program exited");
    }

    private void displayMainMenu() {
        System.out.println(MENU);
    }

    private void displayBikeList(List<Bike> bikes, Scanner scanner) {
        for (int i = 0; i < bikes.size(); i++) {
            System.out.println(bikes.get(i));
            if (i != 0 && (i+1) % 10 == 0) {
                System.out.println();
                System.out.printf("Items %s - %s of %s total", i - 8, i + 1, bikes.size());
                System.out.println();
                System.out.println("Please press 'Enter' to continue.");
                scanner.nextLine();
            }
        }
    }

    private void displayEntrySavedMessage() {
        System.out.println("Entry saved.");
    }

    private void displaySavedToFileMessage() {
        System.out.println("Successfully saved to file.");
    }

    private void displayNextCommandMessage() {
        System.out.println("Please type command or 'menu'");
    }

    private void displayUnknownCommandMessage() {
        System.out.println("Unknown command");
        displayNextCommandMessage();
    }
}
