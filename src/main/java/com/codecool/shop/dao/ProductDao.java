package com.codecool.shop.dao;

import com.codecool.shop.model.Supplier;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;

import java.util.List;

/**
 * <h1>Interface of Product Data Access Object</>
 * @author Fanni Skoda
 * @since 2017.05.08.
 */

public interface ProductDao {

    /**
     * Add product object to DAO
     * @param product This parameter is represented the new product, what we want to add
     */
    void add(Product product);

    /**
     * Find product object in DAO
     * @param id This parameter is the link to find the correct product
     * @return This returns the found product object
     */
    Product find(int id);

    /**
     * Remove product object from DAO
     * @param id This parameter is the link to find the correct product
     */
    void remove(int id);

    /**
     * Collect all products from DAO
     * @return This returns a List with all products
     */
    List<Product> getAll();

    /**
     * Collect all products from DAO from the given supplier
     * @param supplier This parameter is selector, which suppliers products we want to see
     * @return This returns a List with all selected products
     */
    List<Product> getBy(Supplier supplier);

    /**
     * Collect all products from DAO from the given product category
     * @param productCategory This parameter is selector, which categories of products we want to see
     * @return This returns a List with all selected products
     */

    List<Product> getBy(ProductCategory productCategory);

}
