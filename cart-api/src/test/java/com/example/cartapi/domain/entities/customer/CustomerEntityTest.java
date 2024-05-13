package com.example.cartapi.domain.entities.customer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.UUID;

public class CustomerEntityTest {

    @Test
    public void givenCustomerEntity_whenIdSet_thenIdGetterReturnsSameValue() {
        // Arrange
        UUID id = UUID.randomUUID();
        CustomerEntity customer = new CustomerEntity();

        // Act
        customer.setId(id);

        // Assert
        Assertions.assertEquals(id, customer.getId());
    }

    @Test
    public void givenCustomerEntity_whenExternalIdSet_thenExternalIdGetterReturnsSameValue() {
        // Arrange
        UUID externalId = UUID.randomUUID();
        CustomerEntity customer = new CustomerEntity();

        // Act
        customer.setExternalID(externalId);

        // Assert
        Assertions.assertEquals(externalId, customer.getExternalID());
    }

    @Test
    public void givenCustomerEntity_whenEmailSet_thenEmailGetterReturnsSameValue() {
        // Arrange
        String email = "example@example.com";
        CustomerEntity customer = new CustomerEntity();

        // Act
        customer.setEmail(email);

        // Assert
        Assertions.assertEquals(email, customer.getEmail());
    }
}
