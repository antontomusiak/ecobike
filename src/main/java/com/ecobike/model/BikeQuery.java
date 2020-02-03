package com.ecobike.model;

/*
 * A class which contains fields and methods
 * for searching Bike objects with user defined
 * parameters
 */
public class BikeQuery {
    private BikeType bikeType;
    private String brand;
    private Integer sizeOfWheels;
    private Integer numberOfGears;
    private Integer weight;
    private Boolean lightsPresent;
    private Integer maxSpeed;
    private Integer batteryCapacity;
    private String color;
    private Integer price;

    //return true if BikeQuery object with given parameters matches Bike object
    public boolean matches(Bike bike) {
        if (bike.getBikeType() == BikeType.FOLDING) {
            return matchesFoldingBike(bike);
        } else {
            return matchesElectricBike(bike);
        }
    }

    //checks FoldingBike for match
    private boolean matchesFoldingBike(Bike bike) {
        FoldingBike foldingBike = (FoldingBike) bike;
        if (this.getBikeType() != foldingBike.getBikeType()) {
            return false;
        }
        if (this.getBrand() != null && !this.getBrand().equals(foldingBike.getBrand())) {
            return false;
        }
        if (this.getSizeOfWheels() != null && this.getSizeOfWheels() != foldingBike.getSizeOfWheels()) {
            return false;
        }
        if (this.getNumberOfGears() != null && this.getNumberOfGears() != foldingBike.getNumberOfGears()) {
            return false;
        }
        if (this.getLightsPresent() != null && this.getLightsPresent() != foldingBike.isLightsPresent()) {
            return false;
        }
        if (this.getColor() != null && !this.getColor().equals(foldingBike.getColor())) {
            return false;
        }
        if (this.getPrice() != null && this.getPrice() != foldingBike.getPrice()) {
            return false;
        }
        return true;
    }

    //checks ElectricBike (E-Bike or Speedelec) for match
    private boolean matchesElectricBike(Bike bike) {
        ElectricBike electricBike = (ElectricBike) bike;
        if (this.getBikeType() != electricBike.getBikeType()) {
            return false;
        }
        if (this.getBrand() != null && !this.getBrand().equals(electricBike.getBrand())) {
            return false;
        }
        if (this.getMaxSpeed() != null && this.getMaxSpeed() != electricBike.getMaxSpeed()) {
            return false;
        }
        if (this.getBatteryCapacity() != null && this.getBatteryCapacity() != electricBike.getBatteryCapacity()) {
            return false;
        }
        if (this.getLightsPresent() != null && this.getLightsPresent() != electricBike.isLightsPresent()) {
            return false;
        }
        if (this.getColor() != null && !this.getColor().equals(electricBike.getColor())) {
            return false;
        }
        if (this.getPrice() != null && this.getPrice() != electricBike.getPrice()) {
            return false;
        }
        return true;
    }

    public BikeType getBikeType() {
        return bikeType;
    }

    public void setBikeType(BikeType bikeType) {
        this.bikeType = bikeType;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getSizeOfWheels() {
        return sizeOfWheels;
    }

    public void setSizeOfWheels(Integer sizeOfWheels) {
        this.sizeOfWheels = sizeOfWheels;
    }

    public Integer getNumberOfGears() {
        return numberOfGears;
    }

    public void setNumberOfGears(Integer numberOfGears) {
        this.numberOfGears = numberOfGears;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Boolean getLightsPresent() {
        return lightsPresent;
    }

    public void setLightsPresent(Boolean lightsPresent) {
        this.lightsPresent = lightsPresent;
    }

    public Integer getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(Integer maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public Integer getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(Integer batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
