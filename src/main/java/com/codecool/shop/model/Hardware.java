package com.codecool.shop.model;


/**
 * <h1>The Hardware type object of Product</h1>
 * <p>Various attributes of hardwares, and related behaviour.</p>
 * @author Fanni Skoda
 * @since 2017.05.08.
 */
public class Hardware extends Product implements Orderable {

    private int warranty;

    public Hardware(String name, float defaultPrice, String currencyString, String description, ProductCategory productCategory, Supplier supplier, int warranty) {
        super(name, defaultPrice, currencyString, description, productCategory, supplier );
        this.warranty = warranty;
    }

    @Override
    public boolean inStock() {
        return true;
    }

}
