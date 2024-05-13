/**
 * Use case interface for creating a new customer.
 * Implementations of this interface define methods for executing the creation of a customer record.
 */
package com.example.cartapi.domain.gateways.useCases.customer;

import com.example.cartapi.domain.dtos.customer.CreateCustomerRecordDTO;
import com.example.cartapi.domain.errors.ValidationException;

public interface CreateCustomerUseCaseInterface {
    /**
     * Executes the use case to create a new customer.
     *
     * @param createCustomerRecordDTO The data transfer object containing information to create the customer.
     */
    void execute(CreateCustomerRecordDTO createCustomerRecordDTO) throws ValidationException;
}
