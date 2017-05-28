package com.codecool.shop.dao;

import com.codecool.shop.model.Supplier;

import java.util.List;

/**
 * <h1>Interface of Supplier Data Access Object</h1>
 * @author Fanni Skoda
 * @since 2017.05.08.
 */

public interface SupplierDao {

    /**
     * Add supplier object to DAO
     * @param supplier This parameter is represented the new supplier, what we want to add
     */
    void add(Supplier supplier);

    /**
     * Find supplier object in DAO
     * @param id This parameter is the link to find the correct supplier
     * @return This returns the found supplier object
     */
    Supplier find(int id);

    /**
     * Remove supplier object from DAO
     * @param id This parameter is the link to find the correct supplier
     */
    void remove(int id);

    /**
     * Collect all suppliers from DAO
     * @return This returns a List with all suppliers
     */
    List<Supplier> getAll();
}
