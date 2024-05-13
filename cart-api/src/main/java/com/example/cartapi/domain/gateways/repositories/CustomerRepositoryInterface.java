/**
 * Interface representing a repository for managing customer data.
 * Implementations of this interface provide methods for creating and finding customers.
 */
package com.example.cartapi.domain.gateways.repositories;

import com.example.cartapi.domain.dtos.customer.CreateCustomerRecordDTO;
import com.example.cartapi.domain.entities.customer.CustomerEntity;

import java.util.UUID;

public interface CustomerRepositoryInterface {
    /**
     * Creates a new customer entity.
     *
     * @param customerEntity The customer entity to be created.
     */
    void create(CustomerEntity customerEntity);

    /**
     * Finds a customer entity by its external identifier.
     *
     * @param externalId The external identifier of the customer entity to find.
     * @return The customer entity found, or null if not found.
     */
    CustomerEntity findByExternalId(UUID externalId);
}
