package com.ecobike.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FoldingBikeTest {

    @Test
    public void equalsShouldReturnTrue() {
        FoldingBike bike1 = new FoldingBike(BikeType.FOLDING, "Benetti",
                14500, true, "red", 100, 6, 12);
        FoldingBike bike2 = new FoldingBike(BikeType.FOLDING, "Benetti",
                14500, true, "red", 100, 6, 12);
        assertEquals(true, bike1.equals(bike2));
    }

    @Test
    public void equalsShouldReturnFalse() {
        //Bike objects of different BikeType
        ElectricBike electricBike = new ElectricBike(BikeType.EBIKE, "Xiaomi",
                19300, true, "beige", 1025, 24, 10000);
        FoldingBike bike1 = new FoldingBike(BikeType.FOLDING, "Ferrari",
                14500, true, "red", 100, 6, 12);
        assertEquals(false, bike1.equals(electricBike));

        //FoldingBike objects with different brand fields
        FoldingBike bike2 = new FoldingBike(BikeType.FOLDING, "Benetti",
                14500, true, "red", 100, 6, 12);
        assertEquals(false, bike1.equals(bike2));

        //FoldingBike objects with different sizeOfWheels fields
        bike1 = new FoldingBike(BikeType.FOLDING, "Benetti",
                14500, true, "red", 100, 6, 12);
        bike2 = new FoldingBike(BikeType.FOLDING, "Benetti",
                14500, true, "red", 100, 4, 12);
        assertEquals(false, bike1.equals(bike2));

        //FoldingBike objects with different numberOfGears fields
        bike1 = new FoldingBike(BikeType.FOLDING, "Benetti",
                14500, true, "red", 100, 6, 10);
        bike2 = new FoldingBike(BikeType.FOLDING, "Benetti",
                14500, true, "red", 100, 6, 12);
        assertEquals(false, bike1.equals(bike2));

        //FoldingBike objects with different nweight fields
        bike1 = new FoldingBike(BikeType.FOLDING, "Benetti",
                15500, true, "red", 100, 6, 10);
        bike2 = new FoldingBike(BikeType.FOLDING, "Benetti",
                14500, true, "red", 100, 6, 12);
        assertEquals(false, bike1.equals(bike2));

        //FoldingBike objects with different color fields
        bike1 = new FoldingBike(BikeType.FOLDING, "Benetti",
                14500, true, "red", 100, 6, 10);
        bike2 = new FoldingBike(BikeType.FOLDING, "Benetti",
                14500, true, "black", 100, 6, 10);
        assertEquals(false, bike1.equals(bike2));

        //FoldingBike objects with different lightsPresent fields
        bike1 = new FoldingBike(BikeType.FOLDING, "Benetti",
                14500, true, "red", 100, 6, 10);
        bike2 = new FoldingBike(BikeType.FOLDING, "Benetti",
                14500, false, "black", 100, 6, 10);
        assertEquals(false, bike1.equals(bike2));

        //FoldingBike objects with different price fields
        bike1 = new FoldingBike(BikeType.FOLDING, "Benetti",
                14500, true, "red", 200, 6, 10);
        bike2 = new FoldingBike(BikeType.FOLDING, "Benetti",
                14500, true, "black", 100, 6, 10);
        assertEquals(false, bike1.equals(bike2));
    }
}
