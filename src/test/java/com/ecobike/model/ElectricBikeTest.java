package com.ecobike.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ElectricBikeTest {

    @Test
    public void equalsShouldReturnTrue() {
        //E-Bike
        ElectricBike bike1 = new ElectricBike(BikeType.EBIKE, "Xiaomi",
                19300, true, "beige", 1025, 24, 10000);
        ElectricBike bike2 = new ElectricBike(BikeType.EBIKE, "Xiaomi",
                19300, true, "beige", 1025, 24, 10000);
        assertEquals(true, bike1.equals(bike2));

        //Speedelec
        bike1 = new ElectricBike(BikeType.SPEEDELEC, "Tesla",
                10500, false, "white", 2500, 35, 25000);
        bike2 = new ElectricBike(BikeType.SPEEDELEC, "Tesla",
                10500, false, "white", 2500, 35, 25000);
        assertEquals(true, bike1.equals(bike2));
    }

    @Test
    public void equalsShouldReturnFalse() {
        //Bike objects of different BikeType
        FoldingBike foldingBike = new FoldingBike(BikeType.FOLDING, "Ferrari",
                14500, true, "red", 100, 6, 12);
        ElectricBike bike1 = new ElectricBike(BikeType.EBIKE, "Xiaomi",
                19300, true, "beige", 1025, 24, 10000);

        assertEquals(false, bike1.equals(foldingBike));

        //Bike objects of different BikeType
        ElectricBike bike2 = new ElectricBike(BikeType.SPEEDELEC, "Tesla",
                10500, false, "white", 2500, 35, 25000);
        assertEquals(false, bike1.equals(bike2));

        //ElectricBike objects with different brand fields
        bike1 = new ElectricBike(BikeType.EBIKE, "Xiaomi",
                19300, true, "beige", 1025, 24, 10000);
        bike2 = new ElectricBike(BikeType.EBIKE, "Tesla",
                19300, true, "beige", 1025, 24, 10000);
        assertEquals(false, bike1.equals(bike2));

        //ElectricBike objects with different maxSpeed fields
        bike1 = new ElectricBike(BikeType.EBIKE, "Tesla",
                29300, true, "beige", 1025, 24, 10000);
        bike2 = new ElectricBike(BikeType.EBIKE, "Tesla",
                29300, true, "beige", 1025, 30, 10000);
        assertEquals(false, bike1.equals(bike2));

        //ElectricBike objects with different weight fields
        bike1 = new ElectricBike(BikeType.EBIKE, "Tesla",
                29300, true, "beige", 1025, 24, 10000);
        bike2 = new ElectricBike(BikeType.EBIKE, "Tesla",
                19300, true, "beige", 1025, 24, 10000);
        assertEquals(false, bike1.equals(bike2));

        //ElectricBike objects with different lightsPresent fields
        bike1 = new ElectricBike(BikeType.EBIKE, "Tesla",
                19300, true, "beige", 1025, 24, 10000);
        bike2 = new ElectricBike(BikeType.EBIKE, "Tesla",
                19300, false, "beige", 1025, 24, 10000);
        assertEquals(false, bike1.equals(bike2));

        //ElectricBike objects with different batteryCapacity fields
        bike1 = new ElectricBike(BikeType.EBIKE, "Tesla",
                19300, false, "beige", 1025, 24, 12000);
        bike2 = new ElectricBike(BikeType.EBIKE, "Tesla",
                19300, false, "beige", 1025, 24, 10000);
        assertEquals(false, bike1.equals(bike2));

        //ElectricBike objects with different color fields
        bike1 = new ElectricBike(BikeType.EBIKE, "Tesla",
                19300, false, "beige", 1025, 24, 12000);
        bike2 = new ElectricBike(BikeType.EBIKE, "Tesla",
                19300, false, "white", 1025, 24, 12000);
        assertEquals(false, bike1.equals(bike2));

        //ElectricBike objects with different price fields
        bike1 = new ElectricBike(BikeType.EBIKE, "Tesla",
                19300, false, "beige", 1025, 24, 12000);
        bike2 = new ElectricBike(BikeType.EBIKE, "Tesla",
                19300, false, "beige", 2025, 24, 12000);
        assertEquals(false, bike1.equals(bike2));
    }
}
