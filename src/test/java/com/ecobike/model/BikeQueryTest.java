package com.ecobike.model;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BikeQueryTest {

    @Test
    public void matchesShouldReturnTrue_FoldingBike() {
        FoldingBike bike = new FoldingBike(BikeType.FOLDING, "Benetti",
                11400, true, "red", 100, 24, 27);
        BikeQuery bikeQuery = new BikeQuery();
        bikeQuery.setBikeType(BikeType.FOLDING);
        bikeQuery.setBrand("Benetti");
        assertEquals(true, bikeQuery.matches(bike));

        bikeQuery.setLightsPresent(true);
        assertEquals(true, bikeQuery.matches(bike));

        bikeQuery.setSizeOfWheels(24);
        assertEquals(true, bikeQuery.matches(bike));

        bikeQuery.setNumberOfGears(27);
        assertEquals(true, bikeQuery.matches(bike));

        bikeQuery.setColor("red");
        assertEquals(true, bikeQuery.matches(bike));

        bikeQuery.setPrice(100);
        assertEquals(true, bikeQuery.matches(bike));

        bikeQuery.setWeight(11400);
        assertEquals(true, bikeQuery.matches(bike));
    }

    @Test
    public void matchesShouldReturnFalse_FoldingBike() {
        FoldingBike bike = new FoldingBike(BikeType.FOLDING, "Benetti",
                11400, true, "red", 100, 24, 27);
        BikeQuery bikeQuery = new BikeQuery();
        bikeQuery.setBikeType(BikeType.FOLDING);
        bikeQuery.setBrand("Xiaomi");
        assertEquals(false, bikeQuery.matches(bike));

        bikeQuery.setLightsPresent(false);
        assertEquals(false, bikeQuery.matches(bike));

        bikeQuery.setSizeOfWheels(20);
        assertEquals(false, bikeQuery.matches(bike));

        bikeQuery.setNumberOfGears(32);
        assertEquals(false, bikeQuery.matches(bike));

        bikeQuery.setColor("black");
        assertEquals(false, bikeQuery.matches(bike));

        bikeQuery.setPrice(110);
        assertEquals(false, bikeQuery.matches(bike));

        bikeQuery.setWeight(12400);
        assertEquals(false, bikeQuery.matches(bike));
    }

    @Test
    public void matchesShouldReturnTrue_ElectricBike() {
        ElectricBike bike = new ElectricBike(BikeType.EBIKE, "Benetti",
                11400, true, "red", 100, 24, 10000);
        BikeQuery bikeQuery = new BikeQuery();
        bikeQuery.setBikeType(BikeType.EBIKE);
        bikeQuery.setBrand("Benetti");
        assertEquals(true, bikeQuery.matches(bike));

        bikeQuery.setLightsPresent(true);
        assertEquals(true, bikeQuery.matches(bike));

        bikeQuery.setMaxSpeed(24);
        assertEquals(true, bikeQuery.matches(bike));

        bikeQuery.setBatteryCapacity(10000);
        assertEquals(true, bikeQuery.matches(bike));

        bikeQuery.setColor("red");
        assertEquals(true, bikeQuery.matches(bike));

        bikeQuery.setPrice(100);
        assertEquals(true, bikeQuery.matches(bike));

        bikeQuery.setWeight(11400);
        assertEquals(true, bikeQuery.matches(bike));
    }

    @Test
    public void matchesShouldReturnFalse_ElectricBike() {
        ElectricBike bike = new ElectricBike(BikeType.SPEEDELEC, "Benetti",
                11400, true, "red", 100, 24, 10000);
        BikeQuery bikeQuery = new BikeQuery();
        bikeQuery.setBikeType(BikeType.EBIKE);
        assertEquals(false, bikeQuery.matches(bike));

        bikeQuery.setBikeType(BikeType.SPEEDELEC);
        bikeQuery.setBrand("Tesla");
        assertEquals(false, bikeQuery.matches(bike));

        bikeQuery.setLightsPresent(false);
        assertEquals(false, bikeQuery.matches(bike));

        bikeQuery.setMaxSpeed(17);
        assertEquals(false, bikeQuery.matches(bike));

        bikeQuery.setBatteryCapacity(9000);
        assertEquals(false, bikeQuery.matches(bike));

        bikeQuery.setColor("white");
        assertEquals(false, bikeQuery.matches(bike));

        bikeQuery.setPrice(200);
        assertEquals(false, bikeQuery.matches(bike));

        bikeQuery.setWeight(15000);
        assertEquals(false, bikeQuery.matches(bike));
    }
}
