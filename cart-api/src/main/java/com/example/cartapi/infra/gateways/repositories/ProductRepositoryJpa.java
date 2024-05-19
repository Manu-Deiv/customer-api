package com.example.cartapi.infra.gateways.repositories;

import com.example.cartapi.domain.entities.product.ProductEntity;
import com.example.cartapi.domain.gateways.repositories.ProductRepositoryInterface;
import com.example.cartapi.infra.gateways.mapper.ProductModelMapper;
import com.example.cartapi.infra.persistence.models.ProductModel;
import com.example.cartapi.infra.persistence.repositories.ProductRepository;

import java.util.Optional;
import java.util.UUID;

public class ProductRepositoryJpa implements ProductRepositoryInterface {
    private final ProductRepository repository;
    private final ProductModelMapper mapper;

    public ProductRepositoryJpa(ProductRepository repository, ProductModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public void create(ProductEntity productEntity) {
        ProductModel productModel = mapper.toModel(productEntity);
        repository.save(productModel);
    }

    @Override
    public ProductEntity findByExternalID(UUID externalId) {
        Optional<ProductModel> productModel = repository.findByExternalId(externalId);
        return productModel.map(mapper::toDomain).orElse(null);
    }
}
