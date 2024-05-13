package com.example.cartapi.domain.entities.cart;

import com.example.cartapi.domain.entities.CartEntity;
import com.example.cartapi.domain.entities.product.ProductEntity;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class CartEntityFactoryTest {

    @Test
    public void testCreateCartEntity_DefaultValues() {
        // Act
        CartEntity cartEntity = CartEntityFactory.createCartEntity();

        // Assert
        assertNotNull(cartEntity);
        assertNotNull(cartEntity.getId());
        assertNull(cartEntity.getCustomerId());
        assertTrue(cartEntity.getProducts().isEmpty());
    }

    @Test
    public void testCreateCartEntity_WithCustomerId() {
        // Arrange
        UUID customerId = UUID.randomUUID();

        // Act
        CartEntity cartEntity = CartEntityFactory.createCartEntity(customerId);

        // Assert
        assertNotNull(cartEntity);
        assertNotNull(cartEntity.getId());
        assertEquals(customerId, cartEntity.getCustomerId());
        assertTrue(cartEntity.getProducts().isEmpty());
    }

    @Test
    public void testCreateCartEntity_WithCustomerIdAndProducts() {
        // Arrange
        UUID customerId = UUID.randomUUID();
        List<ProductEntity> products = List.of(new ProductEntity(/* product details */));

        // Act
        CartEntity cartEntity = CartEntityFactory.createCartEntity(customerId, products);

        // Assert
        assertNotNull(cartEntity);
        assertNotNull(cartEntity.getId());
        assertEquals(customerId, cartEntity.getCustomerId());
        assertFalse(cartEntity.getProducts().isEmpty());
        assertEquals(products.size(), cartEntity.getProducts().size());
    }
}
