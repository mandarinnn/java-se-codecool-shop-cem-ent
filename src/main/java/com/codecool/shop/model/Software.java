package com.codecool.shop.model;

/**
 * <h1>The Software type object of Product</h1>
 * <p>Various attributes of softwares, and related behaviour.</p>
 * @author Fanni Skoda
 * @since 2017.05.08.
 */

public class Software extends Product {

    private int duration;

    public Software(String name, float defaultPrice, String currencyString, String description, ProductCategory productCategory, Supplier supplier, int duration) {
        super(name, defaultPrice, currencyString, description, productCategory, supplier );
        this.duration = duration;
    }
}
