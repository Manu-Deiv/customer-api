package com.example.cartapi.domain.gateways.useCases.product;

import com.example.cartapi.domain.dtos.product.CreateProductRecordDTO;
import com.example.cartapi.domain.errors.ValidationException;

/**
 * Interface representing the use case for creating a product.
 */
public interface CreateProductUseCaseInterface {

    /**
     * Executes the use case for creating a product.
     *
     * @param createProductRecordDTO The DTO containing information for creating the product.
     */
    void execute(CreateProductRecordDTO createProductRecordDTO) throws ValidationException;
}
