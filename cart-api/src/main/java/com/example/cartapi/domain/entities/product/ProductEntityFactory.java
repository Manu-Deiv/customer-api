package com.example.cartapi.domain.entities.product;

import java.math.BigDecimal;
import java.util.UUID;

public class ProductEntityFactory {

    /**
     * Create a new instance of ProductEntity with default values.
     * @return A new ProductEntity instance.
     */
    public static ProductEntity createProductEntity() {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setId(UUID.randomUUID()); // Generate a random UUID for ID
        return productEntity;
    }

    /**
     * Create a new instance of ProductEntity with specified external ID, code, and value.
     * @param externalId The external ID of the product.
     * @param code The code of the product.
     * @param value The value of the product.
     * @return A new ProductEntity instance.
     */
    public static ProductEntity createProductEntity(UUID externalId, String code, BigDecimal value) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setId(UUID.randomUUID());
        productEntity.setExternalId(externalId);
        productEntity.setCode(code);
        productEntity.setValue(value);
        return productEntity;
    }
}
