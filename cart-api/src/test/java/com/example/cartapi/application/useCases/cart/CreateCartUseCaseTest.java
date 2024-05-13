package com.example.cartapi.application.useCases.cart;

import com.example.cartapi.domain.dtos.cart.CreateCartRecordDto;
import com.example.cartapi.domain.entities.CartEntity;
import com.example.cartapi.domain.entities.product.ProductEntity;
import com.example.cartapi.domain.gateways.repositories.CartRepositoryInterface;
import com.example.cartapi.domain.gateways.repositories.ProductRepositoryInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class CreateCartUseCaseTest {

    private CreateCartUseCase createCartUseCase;
    private CartRepositoryInterface cartRepositoryInterface;
    private ProductRepositoryInterface productRepositoryInterface;

    @BeforeEach
    public void setUp() {
        cartRepositoryInterface = Mockito.mock(CartRepositoryInterface.class);
        productRepositoryInterface = Mockito.mock(ProductRepositoryInterface.class);
        createCartUseCase = new CreateCartUseCase(cartRepositoryInterface, productRepositoryInterface);
    }

    @Test
    public void testExecute_CartAlreadyExists() {
        // Arrange
        UUID customerId = UUID.randomUUID();
        CreateCartRecordDto createCartRecordDto = new CreateCartRecordDto(customerId, List.of(UUID.randomUUID()));
        CartEntity existingCart = new CartEntity();
        when(cartRepositoryInterface.findCartByCustomerID(customerId)).thenReturn(existingCart);

        // Act
        CartEntity result = createCartUseCase.execute(createCartRecordDto);

        // Assert
        assertNotNull(result);
        assertEquals(existingCart, result);
        verify(cartRepositoryInterface, times(1)).findCartByCustomerID(customerId);
        verify(cartRepositoryInterface, never()).create(any());
    }

    @Test
    public void testExecute_CartDoesNotExist() {
        // Arrange
        UUID customerId = UUID.randomUUID();
        UUID productId = UUID.randomUUID();
        CreateCartRecordDto createCartRecordDto = new CreateCartRecordDto(customerId, List.of(productId));
        CartEntity newCart = new CartEntity();
        when(cartRepositoryInterface.findCartByCustomerID(customerId)).thenReturn(null);
        when(productRepositoryInterface.findByExternalID(productId)).thenReturn(new ProductEntity());
        when(cartRepositoryInterface.create(any())).thenReturn(newCart);
        // Act
        createCartUseCase.execute(createCartRecordDto);

        // Assert
        verify(cartRepositoryInterface, times(1)).findCartByCustomerID(customerId);
        verify(cartRepositoryInterface, times(1)).create(any());
    }
}
