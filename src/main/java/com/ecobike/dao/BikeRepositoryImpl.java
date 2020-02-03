package com.ecobike.dao;

import com.ecobike.model.Bike;
import com.ecobike.model.BikeQuery;
import com.ecobike.utils.Utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
 * The implementation of BikeRepository interface
 */
public class BikeRepositoryImpl implements BikeRepository {
    private final String fileName;
    private boolean unsaved;
    private List<Bike> bikes = new ArrayList<>();

    public BikeRepositoryImpl(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<Bike> getAll() throws IOException {
        File file = new File(fileName);
        BufferedReader br = new BufferedReader(new FileReader(file));
        int lineNumber = 1;
        String line;
        while ((line = br.readLine()) != null) {
            if (!Utils.isValidInputString(line)) {
                System.out.println("Invalid data format at line " + lineNumber + ": " + line);
                lineNumber++;
                continue;
            }
            Bike bike = Utils.createBike(line);
            bikes.add(bike);
        }
        br.close();
        ArrayList<Bike> bikesCopy = new ArrayList<>(bikes);
        return bikesCopy;
    }

    @Override
    public void add(Bike bike) {
        bikes.add(bike);
    }

    @Override
    public void saveAll() throws IOException {
        BufferedWriter out = new BufferedWriter(new FileWriter(fileName, true));
        for (Bike bike : bikes) {
            out.write(bike.toStringForWriteToFile());
        }
        out.close();
    }

    @Override
    public boolean hasUnsaved() {
        return unsaved;
    }

    @Override
    public Bike find(BikeQuery bikeQuery) {
        for (Bike bike : bikes) {
            if (bikeQuery.matches(bike)) {
                return bike;
            }
        }
        return null;
    }

    public void setUnsaved(boolean unsaved) {
        this.unsaved = unsaved;
    }
}
