package com.ecobike.model;

/* Bike class implementation of Folding Bike.
 * Has fields specific for Folding Bike.
 */
public class FoldingBike extends Bike {
    private final int sizeOfWheels;
    private final int numberOfGears;

    public FoldingBike(BikeType bikeType, String brand, int weight, boolean lightsPresent,
                       String color, int price, int sizeOfWheels, int numberOfGears) {
        super(bikeType, brand, weight, lightsPresent, color, price);
        this.sizeOfWheels = sizeOfWheels;
        this.numberOfGears = numberOfGears;
    }

    public int getSizeOfWheels() {
        return sizeOfWheels;
    }

    public int getNumberOfGears() {
        return numberOfGears;
    }

    @Override
    public String toStringForWriteToFile() {
        return  bikeType.getName() + " "
                + getBrand() + "; "
                + getSizeOfWheels() + "; "
                + getNumberOfGears() + "; "
                + getWeight() + "; "
                + isLightsPresent() + "; "
                + getColor() + "; "
                + getPrice() + "\n";
    }

    public String toString() {
        String lightsOption = lightsPresent ? "head/tail light" : "no head/tail light";
        return bikeType.getName() + " " + getBrand() + " with " + getNumberOfGears() +
                " gear(s) and " + lightsOption + "\n" +
                "Price: " + getPrice() + " euros";
    }

    public boolean equals(Object o) {
        if (!(o instanceof FoldingBike)) {
            return false;
        }
        FoldingBike that = (FoldingBike) o;
        return this.getBikeType().equals(that.getBikeType())
                && this.getBrand().equals(that.getBrand())
                && this.getSizeOfWheels() == that.getSizeOfWheels()
                && this.getNumberOfGears() == that.getNumberOfGears()
                && this.isLightsPresent() == that.isLightsPresent()
                && this.getWeight() == that.getWeight()
                && this.getColor().equals(that.getColor())
                && this.getPrice() == that.getPrice();
    }
}
