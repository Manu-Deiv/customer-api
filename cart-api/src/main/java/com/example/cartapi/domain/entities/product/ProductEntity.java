package com.example.cartapi.domain.entities.product;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * Represents a product entity.
 */
public class ProductEntity {
    private UUID id;
    private UUID externalId;
    private String code;
    private BigDecimal value;

    /**
     * Get the ID of the product.
     * @return The ID of the product.
     */
    public UUID getId() {
        return id;
    }

    /**
     * Set the ID of the product.
     * @param id The ID to set.
     */
    public void setId(UUID id) {
        this.id = id;
    }

    /**
     * Get the external ID of the product.
     * @return The external ID of the product.
     */
    public UUID getExternalId() {
        return externalId;
    }

    /**
     * Set the external ID of the product.
     * @param externalId The external ID to set.
     */
    public void setExternalId(UUID externalId) {
        this.externalId = externalId;
    }

    /**
     * Get the name of the product.
     * @return The name of the product.
     */
    public String getName() {
        return code;
    }

    /**
     * Set the name of the product.
     * @param code The name to set.
     */
    public void setName(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}
