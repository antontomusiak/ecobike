package com.ecobike.dao;

import com.ecobike.model.Bike;
import com.ecobike.model.BikeQuery;

import java.util.List;

/*
 * Bike repository interface.
 * The user of this interface can retrieve all Bike objects,
 * add a new Bike object, save added Bike objects to file, find Bike object
 * corresponding to particular fields
 */
public interface BikeRepository {
    /*
     * returns the list of all entries
     */
    List<Bike> getAll();

    /*
     * adds a new Bike object
     */
    void add(Bike bike);

    /*
     * saves added Bike objects to file
     */
    void saveAll() throws Exception;

    /*
     * return true if there are unsaved Bike object(s)
     */
    boolean hasUnsaved();

    /*
     * finds Bike object corresponding
     * to fields in BikeQuery
     */
    Bike find(BikeQuery bikeQuery);
}
