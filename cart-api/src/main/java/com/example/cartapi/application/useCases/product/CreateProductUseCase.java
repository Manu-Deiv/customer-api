/**
 * Use case implementation for creating a new product.
 * This class implements the CreateProductUseCaseInterface.
 * It handles the business logic for creating a product entity,
 * including validation and interaction with the product repository.
 */
package com.example.cartapi.application.useCases.product;

import com.example.cartapi.domain.entities.product.ProductEntityFactory;
import com.example.cartapi.domain.gateways.repositories.ProductRepositoryInterface;
import com.example.cartapi.domain.dtos.product.CreateProductRecordDTO;
import com.example.cartapi.domain.entities.product.ProductEntity;
import com.example.cartapi.domain.errors.ValidationException;
import com.example.cartapi.domain.gateways.useCases.product.CreateProductUseCaseInterface;

import java.util.UUID;

public class CreateProductUseCase implements CreateProductUseCaseInterface {
    private final ProductRepositoryInterface productRepositoryInterface;

    /**
     * Constructor for CreateProductUseCase.
     *
     * @param productRepositoryInterface The repository for accessing and managing product data.
     */
    public CreateProductUseCase(ProductRepositoryInterface productRepositoryInterface) {
        this.productRepositoryInterface = productRepositoryInterface;
    }

    /**
     * Executes the use case to create a new product.
     *
     * @param createProductRecordDTO The data transfer object containing information to create the product.
     * @throws ValidationException if the product already exists.
     */
    @Override
    public void execute(CreateProductRecordDTO createProductRecordDTO) throws ValidationException {
        ProductEntity productAlreadyExist = productRepositoryInterface.findByExternalID(createProductRecordDTO.externalID());
        if(productAlreadyExist == null){
            throw new ValidationException("Product already exist");
        }

        ProductEntity productEntity = ProductEntityFactory.createProductEntity(
                createProductRecordDTO.externalID(),
                createProductRecordDTO.code(),
                createProductRecordDTO.value()
        );

        productRepositoryInterface.create(productEntity);
    }
}
