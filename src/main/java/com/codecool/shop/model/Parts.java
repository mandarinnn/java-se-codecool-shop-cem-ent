package com.codecool.shop.model;

/**
 * <h1>The Parts type object of Product</h1>
 * <p>Various attributes of parts, and related behaviour.</p>
 * @author Fanni Skoda
 * @since 2017.05.08.
 */

public class Parts extends Product implements Orderable {
    public Parts(String name, float defaultPrice, String currencyString, String description, ProductCategory productCategory, Supplier supplier) {
        super(name, defaultPrice, currencyString, description, productCategory, supplier );
    }

    @Override
    public boolean inStock() {
        return true;
    }
}
