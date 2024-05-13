package com.example.cartapi.application.useCases.cart;

import com.example.cartapi.domain.dtos.cart.CreateCartRecordDto;
import com.example.cartapi.domain.entities.CartEntity;
import com.example.cartapi.domain.entities.cart.CartEntityFactory;
import com.example.cartapi.domain.entities.product.ProductEntity;
import com.example.cartapi.domain.gateways.repositories.CartRepositoryInterface;
import com.example.cartapi.domain.gateways.repositories.ProductRepositoryInterface;
import com.example.cartapi.domain.gateways.useCases.cart.CreateCartUseCaseInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Use case for creating a new cart.
 */
public class CreateCartUseCase implements CreateCartUseCaseInterface {

    private final CartRepositoryInterface cartRepositoryInterface;
    private final ProductRepositoryInterface productRepository;

    /**
     * Constructs a new CreateCartUseCase instance.
     *
     * @param cartRepositoryInterface The cart repository interface.
     * @param productRepository       The product repository interface.
     */
    public CreateCartUseCase(CartRepositoryInterface cartRepositoryInterface, ProductRepositoryInterface productRepository) {
        this.cartRepositoryInterface = cartRepositoryInterface;
        this.productRepository = productRepository;
    }

    /**
     * Executes the create cart use case.
     *
     * @param createCartRecordDto The DTO containing cart creation information.
     * @return The created cart entity.
     */
    @Override
    public CartEntity execute(CreateCartRecordDto createCartRecordDto) {
        List<ProductEntity> products = new ArrayList<>();

        for (UUID externalId : createCartRecordDto.externalIds()) {
            ProductEntity productEntity = productRepository.findByExternalID(externalId);
            if (productEntity != null) {
                products.add(productEntity);
            }
        }

        CartEntity cartEntity = CartEntityFactory.createCartEntity(
                createCartRecordDto.customerId(),
                products
        );

        CartEntity cartAlreadyExist = cartRepositoryInterface.findCartByCustomerID(cartEntity.getCustomerId());
        if (cartAlreadyExist != null) {
            return cartAlreadyExist;
        }

        return cartRepositoryInterface.create(cartEntity);
    }
}
