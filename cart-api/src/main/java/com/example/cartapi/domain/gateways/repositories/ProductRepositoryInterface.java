/**
 * Interface representing a repository for managing product data.
 * Implementations of this interface provide methods for creating and finding products.
 */
package com.example.cartapi.domain.gateways.repositories;

import com.example.cartapi.domain.entities.product.ProductEntity;
import java.util.UUID;

public interface ProductRepositoryInterface {

    /**
     * Creates a new product entity.
     *
     * @param productEntity The product entity to be created.
     */
    void create(ProductEntity productEntity);

    /**
     * Finds a product entity by its unique identifier.
     *
     * @param externalId The unique identifier of the product entity to find.
     * @return The product entity found, or null if not found.
     */
    ProductEntity findByExternalID(UUID externalId);
}
