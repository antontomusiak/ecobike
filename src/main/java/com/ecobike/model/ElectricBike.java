package com.ecobike.model;

/*
 * Bike class implementation for E-BIKE and SpeedElec.
 * Has fields specific for E-BIKE and SpeedElec.
 */
public class ElectricBike extends Bike {
    private int maxSpeed;
    private int batteryCapacity;

    public ElectricBike(BikeType bikeType, String brand, int weight,
                        boolean lightsPresent, String color, int price, int maxSpeed, int batteryCapacity) {
        super(bikeType, brand, weight, lightsPresent, color, price);
        this.maxSpeed = maxSpeed;
        this.batteryCapacity = batteryCapacity;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public boolean equals(Object o) {
        if (!(o instanceof ElectricBike)) {
            return false;
        }
        ElectricBike that = (ElectricBike) o;
        return this.getBikeType().equals(that.getBikeType())
                && this.getBrand().equals(that.getBrand())
                && this.getMaxSpeed() == that.getMaxSpeed()
                && this.isLightsPresent() == that.isLightsPresent()
                && this.getBatteryCapacity() == that.getBatteryCapacity()
                && this.getWeight() == that.getWeight()
                && this.getColor().equals(that.getColor())
                && this.getPrice() == that.getPrice();
    }

    @Override
    public String toStringForWriteToFile() {
        return  bikeType.getName() + " "
                + getBrand() + "; "
                + getMaxSpeed() + "; "
                + getWeight() + "; "
                + isLightsPresent() + "; "
                + getBatteryCapacity() + "; "
                + getColor() + "; "
                + getPrice() + "\n";
    }

    public String toString() {
        String lightsOption = lightsPresent ? "head/tail light" : "no head/tail light";
        return bikeType.getName() + " " + getBrand() + " with " + getBatteryCapacity() +
                " mAh battery and " + lightsOption + "\n" +
                "Price: " + getPrice() + " euros";
    }
}
