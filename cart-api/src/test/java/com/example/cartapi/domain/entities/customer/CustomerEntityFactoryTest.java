package com.example.cartapi.domain.entities.customer;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerEntityFactoryTest {

    @Test
    public void testCreateCustomerEntity_DefaultValues() {
        // Act
        CustomerEntity customerEntity = CustomerEntityFactory.createCustomerEntity();

        // Assert
        assertNotNull(customerEntity);
        assertNotNull(customerEntity.getId());
        assertNull(customerEntity.getExternalID());
        assertNull(customerEntity.getEmail());
    }

    @Test
    public void testCreateCustomerEntity_WithExternalIDAndEmail() {
        // Arrange
        UUID externalID = UUID.randomUUID();
        String email = "test@example.com";

        // Act
        CustomerEntity customerEntity = CustomerEntityFactory.createCustomerEntity(externalID, email);

        // Assert
        assertNotNull(customerEntity);
        assertNotNull(customerEntity.getId());
        assertEquals(externalID, customerEntity.getExternalID());
        assertEquals(email, customerEntity.getEmail());
    }
}
