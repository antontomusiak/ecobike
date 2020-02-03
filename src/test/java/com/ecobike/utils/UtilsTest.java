package com.ecobike.utils;

import com.ecobike.model.Bike;
import com.ecobike.model.BikeType;
import com.ecobike.model.ElectricBike;
import com.ecobike.model.FoldingBike;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UtilsTest {

    @Test
    public void isValidInputStringShouldReturnTrue() {
        String input = "SPEEDELEC Booster; 35; 10900; false; 13200; green; 1279";
        assertEquals(true, Utils.isValidInputString(input));

        input = "E-BIKE ElectrO; 20;    19300; true; 14000;   beige; 1025";
        assertEquals(true, Utils.isValidInputString(input));

        input = "FOLDING BIKE Intertool; 24;   21; 12900; true;   coral; 1565";
        assertEquals(true, Utils.isValidInputString(input));
    }

    @Test
    public void isValidInputStringShouldReturnFalse() {
        String input = "SPEEDELEC ; 35; 10900; false; 13200; green; 1279";
        assertEquals(false, Utils.isValidInputString(input));

        input = "E-BIKE ElectrO; 20; 19300; true; 14000; beige;";
        assertEquals(false, Utils.isValidInputString(input));

        input = "FOLDING BIKE Intertool; ; 21; 12900; true; coral; 1565";
        assertEquals(false, Utils.isValidInputString(input));
    }

    @Test
    public void createBikeShouldReturnFoldingBike() {
        FoldingBike bike1 = new FoldingBike(BikeType.FOLDING, "Intertool",
                12900, true, "coral", 1565, 24, 21);
        String input = "FOLDING BIKE Intertool; 24;   21; 12900; true;   coral; 1565";
        Bike bike2 = Utils.createBike(input);
        assertEquals(true, bike1.equals(bike2));
    }

    @Test
    public void createBikeShouldReturnEBike() {
        ElectricBike bike1 = new ElectricBike(BikeType.EBIKE, "Xiaomi",
                19300, true, "beige", 1025, 24, 10000);
        String input = "E-BIKE Xiaomi; 24;    19300; true; 10000;   beige; 1025";
        Bike bike2 = Utils.createBike(input);
        assertEquals(true, bike1.equals(bike2));
    }

    @Test
    public void createBikeShouldReturnSpeedelec() {
        ElectricBike bike1 = new ElectricBike(BikeType.SPEEDELEC, "Tesla",
                10500, false, "white", 2500, 35, 25000);
        String input = "SPEEDELEC   Tesla;  35;    10500; false; 25000;   white; 2500";
        Bike bike2 = Utils.createBike(input);
        assertEquals(true, bike1.equals(bike2));
    }
}
