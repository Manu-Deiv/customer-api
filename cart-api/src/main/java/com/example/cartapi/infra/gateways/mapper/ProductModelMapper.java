package com.example.cartapi.infra.gateways.mapper;

import com.example.cartapi.domain.entities.product.ProductEntity;
import com.example.cartapi.domain.entities.product.ProductEntityFactory;
import com.example.cartapi.infra.persistence.models.ProductModel;

public class ProductModelMapper {

    public ProductModel toModel(ProductEntity productEntity){
        return new ProductModel(
                productEntity.getExternalId(),
                productEntity.getCode(),
                productEntity.getValue()
        );
    }
    public ProductEntity toDomain(ProductModel productModel){
        return  ProductEntityFactory.createProductEntity(
                productModel.getId(),
                productModel.getExternalId(),
                productModel.getCode(),
                productModel.getValue()
        );
    }
}
