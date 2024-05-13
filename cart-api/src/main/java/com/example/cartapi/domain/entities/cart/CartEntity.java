package com.example.cartapi.domain.entities;

import com.example.cartapi.domain.entities.product.ProductEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Represents a cart entity.
 */
public class CartEntity {
    private UUID id;
    private UUID customerId;
    private final List<ProductEntity> products;

    /**
     * Constructs a new cart entity.
     */
    public CartEntity() {
        this.products = new ArrayList<>();
    }

    /**
     * Get the ID of the cart.
     * @return The ID of the cart.
     */
    public UUID getId() {
        return id;
    }

    /**
     * Set the ID of the cart.
     * @param id The ID to set.
     */
    public void setId(UUID id) {
        this.id = id;
    }

    /**
     * Get the ID of the customer associated with the cart.
     * @return The ID of the customer.
     */
    public UUID getCustomerId() {
        return customerId;
    }

    /**
     * Set the ID of the customer associated with the cart.
     * @param customerId The customer ID to set.
     */
    public void setCustomerId(UUID customerId) {
        this.customerId = customerId;
    }

    /**
     * Get the list of products in the cart.
     * @return The list of products.
     */
    public List<ProductEntity> getProducts() {
        return products;
    }

    /**
     * Add a product to the cart.
     * @param product The product to add.
     */
    public void addProduct(ProductEntity product) {
        this.products.add(product);
    }

    /**
     * Remove a product from the cart.
     * @param product The product to remove.
     */
    public void removeProduct(ProductEntity product) {
        this.products.remove(product);
    }

    /**
     * Clear all products from the cart.
     */
    public void clearProducts() {
        this.products.clear();
    }
}
