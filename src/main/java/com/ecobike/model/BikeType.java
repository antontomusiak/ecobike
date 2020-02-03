package com.ecobike.model;

public enum BikeType {
    FOLDING("FOLDING BIKE"),
    SPEEDELEC("SPEEDELEC"),
    EBIKE("E-BIKE");

    private final String name;

    BikeType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
