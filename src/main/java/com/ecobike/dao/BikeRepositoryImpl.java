package com.ecobike.dao;

import com.ecobike.model.Bike;
import com.ecobike.model.BikeQuery;
import com.ecobike.utils.Utils;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * The implementation of BikeRepository interface
 */
public class BikeRepositoryImpl implements BikeRepository {
    private final String fileName;
    private boolean unsaved;
    private List<Bike> bikes = new ArrayList<>();

    public BikeRepositoryImpl(String fileName) throws IOException {
        this.fileName = fileName;
        readDataFromFile(fileName);
    }

    @Override
    public List<Bike> getAll() throws IOException {

        return Collections.unmodifiableList(bikes);
    }

    @Override
    public void add(Bike bike) {
        bikes.add(bike);
        setUnsaved(true);
    }

    @Override
    public void saveAll() throws IOException {
        BufferedWriter out = new BufferedWriter(new FileWriter(fileName, false));
        for (Bike bike : bikes) {
            out.write(bike.toStringForWriteToFile());
        }
        out.close();
        setUnsaved(false);
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
    //sets to true when a new Bike object added, sets to false after data saved to file
    private void setUnsaved(boolean unsaved) {
        this.unsaved = unsaved;
    }

    //reads data from file provided by User
    private void readDataFromFile(String fileName) throws IOException {
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
    }
}
