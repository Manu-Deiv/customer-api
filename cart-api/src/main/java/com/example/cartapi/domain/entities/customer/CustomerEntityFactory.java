package com.example.cartapi.domain.entities.customer;

import java.util.UUID;

public class CustomerEntityFactory {

    /**
     * Create a new instance of CustomerEntity with default values.
     * @return A new CustomerEntity instance.
     */
    public static CustomerEntity createCustomerEntity() {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setId(UUID.randomUUID()); // Generate a random UUID for ID
        return customerEntity;
    }

    /**
     * Create a new instance of CustomerEntity with specified external ID and email.
     * @param externalID The external ID of the customer.
     * @param email The email of the customer.
     * @return A new CustomerEntity instance.
     */
    public static CustomerEntity createCustomerEntity(UUID externalID, String email) {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setId(UUID.randomUUID()); // Generate a random UUID for ID
        customerEntity.setExternalID(externalID);
        customerEntity.setEmail(email);
        return customerEntity;
    }
}
