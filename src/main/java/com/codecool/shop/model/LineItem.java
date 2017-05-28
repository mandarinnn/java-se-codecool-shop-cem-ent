package com.codecool.shop.model;

/**
 * <h1>The Line Item object</h1>
 * <p>Various attributes of line items, and related behaviour.
 * Every line item is from {@link Product} object </p>
 * @author Fanni Skoda
 * @since 2017.05.08.
 */

public class LineItem {
    private final Product product;
    private int quantity = 1;

    public LineItem(Product product) {
        this.product = product;
    }

    float getPrice() {
        return product.getDefaultPrice() * quantity;
    }

    public Product getProduct() {
        return product;
    }

    int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    void incrementQuantity() {
        this.quantity += 1;
    }
    
}
