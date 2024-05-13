package com.example.cartapi.domain.entities.product;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class ProductEntityFactoryTest {

    @Test
    public void testCreateProductEntity_DefaultValues() {
        // Act
        ProductEntity productEntity = ProductEntityFactory.createProductEntity();

        // Assert
        assertNotNull(productEntity);
        assertNotNull(productEntity.getId());
        assertNull(productEntity.getExternalId());
        assertNull(productEntity.getCode());
        assertNull(productEntity.getValue());
    }

    @Test
    public void testCreateProductEntity_WithExternalIdCodeAndValue() {
        // Arrange
        UUID externalId = UUID.randomUUID();
        String code = "PROD123";
        BigDecimal value = BigDecimal.valueOf(10.99);

        // Act
        ProductEntity productEntity = ProductEntityFactory.createProductEntity(externalId, code, value);

        // Assert
        assertNotNull(productEntity);
        assertNotNull(productEntity.getId());
        assertEquals(externalId, productEntity.getExternalId());
        assertEquals(code, productEntity.getCode());
        assertEquals(value, productEntity.getValue());
    }
}
