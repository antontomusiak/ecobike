package com.ecobike.utils;

import com.ecobike.model.Bike;
import com.ecobike.model.BikeType;
import com.ecobike.model.ElectricBike;
import com.ecobike.model.FoldingBike;

/*
 * Utils class with static methods which
 * provide String validation and Bike object
 * creation from file strings and User input
 */
public class Utils {

    //checks line from file
    public static boolean isValidInputString(String line) {
        String[] splittedLine = line.split(";");
        if (splittedLine.length < 7) {
            return false;
        }
        if (splittedLine[0].trim().startsWith("FOLDING BIKE")) {
            return checkFoldingBikeData(splittedLine);
        } else if (splittedLine[0].trim().startsWith("E-BIKE") || splittedLine[0].trim().startsWith("SPEEDELEC")) {
            return checkElectricData(splittedLine);
        } else {
            return false;
        }
    }

    //creates Bike object from file line or User input
    public static Bike createBike(String line) {
        String bikeType = line.split(";")[0].split(" ")[0].trim();
        switch (bikeType) {
            case "FOLDING":
                FoldingBike foldingBike = createFoldingBike(line);
                return foldingBike;
            case "E-BIKE":
            case "SPEEDELEC":
                ElectricBike eBike = createElectricBike(line);
                return eBike;
            default:
                return null;
        }
    }

    private static FoldingBike createFoldingBike(String line) {
        String[] splittedLine = line.split(";");
        BikeType bikeType = BikeType.FOLDING;
        String brand = splittedLine[0].substring(splittedLine[0].indexOf("E")+1).trim();
        int sizeOfWheels = Integer.parseInt(splittedLine[1].trim());
        int numberOfGears = Integer.parseInt(splittedLine[2].trim());
        int weight = Integer.parseInt(splittedLine[3].trim());
        boolean lightsPresent = Boolean.parseBoolean(splittedLine[4].trim());
        String color = splittedLine[5].trim();
        int price = Integer.parseInt(splittedLine[6].trim());
        return new FoldingBike(bikeType, brand, weight, lightsPresent, color, price, sizeOfWheels, numberOfGears);
    }

    private static ElectricBike createElectricBike(String line) {
        String[] splittedLine = line.split(";");
        BikeType bikeType;
        String brand;
        if (splittedLine[0].split(" ")[0].trim().equals("E-BIKE")) {
            bikeType = BikeType.EBIKE;
            brand = splittedLine[0].trim().substring(splittedLine[0].indexOf(" ")).trim();
        } else {
            bikeType = BikeType.SPEEDELEC;
            brand = splittedLine[0].substring(splittedLine[0].indexOf("C")+1).trim();
        }
        int maxSpeed = Integer.parseInt(splittedLine[1].trim());
        int weight = Integer.parseInt(splittedLine[2].trim());
        boolean lightsPresent = Boolean.parseBoolean(splittedLine[3].trim());
        int batteryCapacity = Integer.parseInt(splittedLine[4].trim());
        String color = splittedLine[5].trim();
        int price = Integer.parseInt(splittedLine[6].trim());
        return new ElectricBike(bikeType, brand, weight, lightsPresent, color, price, maxSpeed, batteryCapacity);
    }

    private static boolean checkFoldingBikeData(String[] splittedLine) {
        if (splittedLine[0].trim().endsWith("FOLDING BIKE")) {
            return false;
        }
        if (!isPositiveNumeric(splittedLine[1].trim()) || !isPositiveNumeric(splittedLine[2].trim())
                || !isPositiveNumeric(splittedLine[3].trim()) || !isPositiveNumeric(splittedLine[6].trim())) {
            return false;
        }
        if (!splittedLine[4].trim().equals("true") && !splittedLine[4].trim().equals("false")) {
            return false;
        }
        if (splittedLine[4].trim().length() == 0) {
            return false;
        }
        return true;
    }

    private static boolean checkElectricData(String[] splittedLine) {
        if (splittedLine[0].trim().endsWith("E-BIKE") || splittedLine[0].trim().endsWith("SPEEDELEC")) {
            return false;
        }
        if (!isPositiveNumeric(splittedLine[1].trim()) || !isPositiveNumeric(splittedLine[2].trim())
                || !isPositiveNumeric(splittedLine[4].trim()) || !isPositiveNumeric(splittedLine[6].trim())) {
            return false;
        }
        if (!splittedLine[3].trim().equals("true") && !splittedLine[3].trim().equals("false")) {
            return false;
        }
        if (splittedLine[5].trim().length() == 0) {
            return false;
        }
        return true;
    }

    private static boolean isPositiveNumeric(String data) {
        int res = 0;
        try {
            res = Integer.parseInt(data);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return res > 0;
    }
}
