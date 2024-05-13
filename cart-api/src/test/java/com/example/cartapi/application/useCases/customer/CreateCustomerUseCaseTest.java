package com.example.cartapi.application.useCases.customer;

import com.example.cartapi.domain.dtos.customer.CreateCustomerRecordDTO;
import com.example.cartapi.domain.entities.customer.CustomerEntity;
import com.example.cartapi.domain.errors.ValidationException;
import com.example.cartapi.domain.gateways.repositories.CustomerRepositoryInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.BeanUtils;


import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CreateCustomerUseCaseTest {

    @Mock
    private CustomerRepositoryInterface customerRepository;

    private CreateCustomerUseCase createCustomerUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        createCustomerUseCase = new CreateCustomerUseCase(customerRepository);
    }

    @Test
    void execute_ValidCustomer_SuccessfullyCreated() throws ValidationException {
        // Arrange
        CreateCustomerRecordDTO createCustomerRecordDTO = new CreateCustomerRecordDTO(
                UUID.randomUUID(),
                UUID.randomUUID(),
                "test@example.com"
        );
        CustomerEntity expectedCustomerEntity = new CustomerEntity();
        BeanUtils.copyProperties(createCustomerRecordDTO, expectedCustomerEntity);

        when(customerRepository.findByExternalId(any(UUID.class))).thenReturn(expectedCustomerEntity);

        // Act
        createCustomerUseCase.execute(createCustomerRecordDTO);

        // Assert
        verify(customerRepository, times(1)).create(any(CustomerEntity.class));
    }

    @Test
    void execute_CustomerAlreadyExists_ValidationExceptionThrown() {
        // Arrange
        CreateCustomerRecordDTO createCustomerRecordDTO = new CreateCustomerRecordDTO(
                UUID.randomUUID(),
                UUID.randomUUID(),
                "test@example.com"
        );

        when(customerRepository.findByExternalId(any(UUID.class))).thenReturn(null);

        // Act & Assert
        ValidationException thrown = assertThrows(ValidationException.class, () -> createCustomerUseCase.execute(createCustomerRecordDTO));
        assertEquals("Customer already exist", thrown.getMessage());
    }
}
