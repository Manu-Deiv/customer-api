package com.example.cartapi.application.useCases.product;

import com.example.cartapi.domain.gateways.repositories.ProductRepositoryInterface;
import com.example.cartapi.domain.dtos.product.CreateProductRecordDTO;
import com.example.cartapi.domain.entities.product.ProductEntity;
import com.example.cartapi.domain.errors.ValidationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CreateProductUseCaseTest {

    @Mock
    private ProductRepositoryInterface productRepositoryInterface;

    @Autowired
    @InjectMocks
    private  CreateProductUseCase createProductUseCase;

    @BeforeEach
    void  start(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void execute_ValidProduct_SuccessfullyCreated() throws ValidationException {
        // Arrange
        UUID externalId = UUID.randomUUID();
        CreateProductRecordDTO createProductRecordDTO = new CreateProductRecordDTO(externalId, "Test Product", BigDecimal.valueOf(100), "TP1");
        ProductEntity expectedProductEntity = new ProductEntity();
        BeanUtils.copyProperties(createProductRecordDTO, expectedProductEntity);

        when(productRepositoryInterface.findByExternalID(any(UUID.class))).thenReturn(expectedProductEntity);


        // Act
        createProductUseCase.execute(createProductRecordDTO);

        // Assert
        verify(productRepositoryInterface, times(1)).findByExternalID(any());
        verify(productRepositoryInterface, times(1)).create(any());
    }

    @Test
    void execute_ProductAlreadyExists_ValidationExceptionThrown() {
        // Arrange
        UUID externalId = UUID.randomUUID();
        CreateProductRecordDTO createProductRecordDTO = new CreateProductRecordDTO(externalId, "Test Product", BigDecimal.valueOf(100), "TP1");

        when(productRepositoryInterface.findByExternalID(any(UUID.class))).thenReturn(null);

        // Act & Assert
        ValidationException thrown = assertThrows(ValidationException.class, () -> createProductUseCase.execute(createProductRecordDTO));
        assertEquals("Product already exist", thrown.getMessage());
    }
}
