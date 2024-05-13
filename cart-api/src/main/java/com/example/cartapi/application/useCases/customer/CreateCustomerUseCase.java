/**
 * Use case implementation for creating a new customer.
 * This class implements the CreateCustomerUseCaseInterface.
 * It handles the business logic for creating a customer entity,
 * including validation and interaction with the customer repository.
 */
package com.example.cartapi.application.useCases.customer;

import com.example.cartapi.domain.dtos.customer.CreateCustomerRecordDTO;
import com.example.cartapi.domain.entities.customer.CustomerEntity;
import com.example.cartapi.domain.entities.customer.CustomerEntityFactory;
import com.example.cartapi.domain.errors.ValidationException;
import com.example.cartapi.domain.gateways.repositories.CustomerRepositoryInterface;
import com.example.cartapi.domain.gateways.useCases.customer.CreateCustomerUseCaseInterface;



public class CreateCustomerUseCase implements CreateCustomerUseCaseInterface {
    private final CustomerRepositoryInterface customerRepository;

    /**
     * Constructor for CreateCustomerUseCase.
     *
     * @param customerRepository The repository for accessing and managing customer data.
     */
    public CreateCustomerUseCase(CustomerRepositoryInterface customerRepository) {
        this.customerRepository = customerRepository;
    }

    /**
     * Executes the use case to create a new customer.
     *
     * @param createCustomerRecordDTO The data transfer object containing information to create the customer.
     * @throws ValidationException if the customer already exists.
     */
    @Override
    public void execute(CreateCustomerRecordDTO createCustomerRecordDTO) throws ValidationException {
        CustomerEntity customerAlreadyExist = customerRepository.findByExternalId(createCustomerRecordDTO.externalID());
        if(customerAlreadyExist == null){
            throw new ValidationException("Customer already exist");
        }
        CustomerEntity customerEntity = CustomerEntityFactory.createCustomerEntity(
                createCustomerRecordDTO.externalID(),
                createCustomerRecordDTO.email()
        );

        customerRepository.create(customerEntity);
    }
}
