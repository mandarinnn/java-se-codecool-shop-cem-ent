package com.codecool.shop.model;

/**
 * <h1>The Line Item object</h1>
 * <P>Various attributes of line items, and related behaviour.
 * Every line item is from {@link Product} object
 * @author Fanni Skoda
 * @since 2017.05.08.
 */

public class LineItem {
    private final Product product;
    private int quantity = 1;

    public LineItem(Product product) {
        this.product = product;
    }

    public float getPrice() {
        return product.getDefaultPrice() * quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     *
     */
    public void incrementQuantity() {
        this.quantity += 1;
    }
    
}
