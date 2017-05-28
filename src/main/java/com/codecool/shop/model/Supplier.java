package com.codecool.shop.model;

import java.util.ArrayList;

/**
 * <h1>The Supplier Object</h1>
 * <p>Various attributes of suppliers, and related behaviour.</p>
 * @author Fanni Skoda
 * @since 2017.05.08.
 */

public class Supplier extends BaseModel {
    private ArrayList<Product> products;

    public Supplier(String name, String description) {
        super(name, description);
        this.products = new ArrayList<>();
    }

    public Supplier(int id, String name, String description) {
        super(id, name, description);
        this.products = new ArrayList<>();
    }



    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public ArrayList getProducts() {
        return this.products;
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public String toString() {
        return String.format("id: %1$d, " +
                        "name: %2$s, " +
                        "description: %3$s",
                this.id,
                this.name,
                this.description
        );
    }
}