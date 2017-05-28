package com.codecool.shop.model;

/**
 * <h1>The Interface of Orderable Product</h1>
 * @author Fanni Skoda
 * @since 2017.05.08.
 */
public interface Orderable {

    /**
     *
     * @return This returns true, if product is orderable, false if not
     */
    boolean inStock();
}
