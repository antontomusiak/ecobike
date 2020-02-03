package com.ecobike.model;

/*
 * Base class for Bike objects
 */
public abstract class Bike {
    protected BikeType bikeType;
    protected String brand;
    protected int weight;
    protected boolean lightsPresent;
    protected String color;
    protected int price;

    public Bike(BikeType bikeType, String brand, int weight, boolean lightsPresent, String color, int price) {
        this.bikeType = bikeType;
        this.brand = brand;
        this.weight = weight;
        this.lightsPresent = lightsPresent;
        this.color = color;
        this.price = price;
    }

    public BikeType getBikeType() {
        return bikeType;
    }

    public String getBrand() {
        return brand;
    }

    public int getWeight() {
        return weight;
    }

    public boolean isLightsPresent() {
        return lightsPresent;
    }

    public String getColor() {
        return color;
    }

    public int getPrice() {
        return price;
    }

    //returns String formatted for writing to file
    public abstract String toStringForWriteToFile();
}
