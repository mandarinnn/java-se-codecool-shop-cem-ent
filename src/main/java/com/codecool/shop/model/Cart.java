package com.codecool.shop.model;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Cart{
    Date created = new Date();
    private final List<LineItem> lineItems = new ArrayList<>();


    public void add(LineItem lineItem) {
        if (hasProduct(lineItem)) {
            findLineItem(lineItem).incrementQuantity();
        }
        else {
            lineItems.add(lineItem);
        }
    }

    public List<LineItem> getAll() {
        return lineItems;
    }

    public void remove(LineItem lineItem) {
        lineItems.remove(findLineItem(lineItem));
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

    public float getSum() {
        float sum = 0;
        for (LineItem lineItem : lineItems) {
            sum += lineItem.getPrice();
        }
        return sum;
    }

    public int getAllQuantity(){
        int allQuantity = 0;
        for (LineItem lineItem : lineItems) {
            allQuantity += lineItem.getQuantity();
        }
        return allQuantity;
    }
}
