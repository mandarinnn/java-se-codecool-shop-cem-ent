package com.codecool.shop.model;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * <h1>The Cart object</h1>
 * <P>Various attributes of Cart singleton, and related behaviour.
 * Cart is a collection of {@link LineItem}s
 * @author Fanni Skoda
 * @since 2017.05.08.
 */


public class Cart{
    Date created = new Date();
    private final List<LineItem> lineItems = new ArrayList<>();

    /**
     * Add line item object to cart
     * @param lineItem This parameter is represented the new line item, what we want to add.
     *                 If the item is already present, then the amount is incremented
     */
    public void add(LineItem lineItem) {
        if (hasProduct(lineItem)) {
            findLineItem(lineItem).incrementQuantity();
        }
        else {
            lineItems.add(lineItem);
        }
    }

    /**
     * Collect all line items from cart
     * @return This returns a List with all line items from cart
     */
    public List<LineItem> getAll() {
        return lineItems;
    }

    /**
     * Remove line item object from cart
     * @param lineItem This parameter is the item, what we want to remove
     */
    public void remove(LineItem lineItem) {
        lineItems.remove(findLineItem(lineItem));
    }

    /**
     * Get the sum of price of the line items in cart
     * @return This returns the sum of items
     */
    public float getSum() {
        float sum = 0;
        for (LineItem lineItem : lineItems) {
            sum += lineItem.getPrice();
        }
        return sum;
    }

    /**
     * Get the sum of quantity of all line items in cart
     * @return This returns the all quantity
     */
    public int getAllQuantity(){
        int allQuantity = 0;
        for (LineItem lineItem : lineItems) {
            allQuantity += lineItem.getQuantity();
        }
        return allQuantity;
    }

    private LineItem findLineItem(LineItem lineItem) {
        return lineItems.stream()
                .filter(l -> l.getProduct().getId() == lineItem.getProduct().getId())
                .findFirst().orElse(null);
    }

    private boolean hasProduct(LineItem lineItem) {
        return lineItems.stream()
                .anyMatch(li -> li.getProduct().getId() == lineItem.getProduct().getId());
    }


}
