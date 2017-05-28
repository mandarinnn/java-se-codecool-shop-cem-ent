package com.codecool.shop.dao;

import com.codecool.shop.model.ProductCategory;

import java.util.List;

/**
 * <h1>Interface of Product Category Data Access Object</>
 * @author Fanni Skoda
 * @since 2017.05.08.
 */

public interface ProductCategoryDao {

    /**
     * Add product category object to DAO
     * @param category This parameter is represented the new category, what we want to add
     */
    void add(ProductCategory category);

    /**
     * Find product category object in DAO
     * @param id This parameter is the link to find the correct category
     * @return This returns the found category object
     */
    ProductCategory find(int id);

    /**
     * Remove product category object from DAO
     * @param id This parameter is the link to find the correct category
     */
    void remove(int id);

    /**
     * Collect all product categories from DAO
     * @return This returns a List with all product categories
     */
    List<ProductCategory> getAll();

}
