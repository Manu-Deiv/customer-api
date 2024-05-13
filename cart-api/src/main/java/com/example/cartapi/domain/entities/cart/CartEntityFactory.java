package com.example.cartapi.domain.entities.cart;

import com.example.cartapi.domain.entities.CartEntity;
import com.example.cartapi.domain.entities.product.ProductEntity;

import java.util.List;
import java.util.UUID;

public class CartEntityFactory {

    /**
     * Create a new instance of CartEntity with default values.
     * @return A new CartEntity instance.
     */
    public static CartEntity createCartEntity() {
        CartEntity cartEntity = new CartEntity();
        cartEntity.setId(UUID.randomUUID()); // Generate a random UUID for ID
        return cartEntity;
    }

    /**
     * Create a new instance of CartEntity with specified customer ID.
     * @param customerId The ID of the customer associated with the cart.
     * @return A new CartEntity instance.
     */
    public static CartEntity createCartEntity(UUID customerId) {
        CartEntity cartEntity = new CartEntity();
        cartEntity.setId(UUID.randomUUID()); // Generate a random UUID for ID
        cartEntity.setCustomerId(customerId);
        return cartEntity;
    }

    /**
     * Create a new instance of CartEntity with specified customer ID and initial products.
     * @param customerId The ID of the customer associated with the cart.
     * @param products The initial list of products in the cart.
     * @return A new CartEntity instance.
     */
    public static CartEntity createCartEntity(UUID customerId, List<ProductEntity> products) {
        CartEntity cartEntity = new CartEntity();
        cartEntity.setId(UUID.randomUUID()); // Generate a random UUID for ID
        cartEntity.setCustomerId(customerId);
        if (products != null) {
            cartEntity.getProducts().addAll(products);
        }
        return cartEntity;
    }
}
