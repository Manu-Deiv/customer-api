package com.example.cartapi.domain.gateways.repositories;

import com.example.cartapi.domain.entities.CartEntity;

import java.util.UUID;

/**
 * Interface representing a repository for managing cart entities.
 */
public interface CartRepositoryInterface {

    /**
     * Creates a new cart entity.
     *
     * @param cartEntity The cart entity to be created.
     * @return The created cart entity.
     */
    CartEntity create(CartEntity cartEntity);
    CartEntity findCartByCustomerID(UUID customerID);
}
