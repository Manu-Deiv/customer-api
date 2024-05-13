package com.example.cartapi.domain.entities.product;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.UUID;

public class ProductEntityTest {

    @Test
    public void givenProductEntityWhenIdSetThenIdGetterReturnsSameValue() {
        UUID id = UUID.randomUUID();
        ProductEntity productEntity = new ProductEntity();

        productEntity.setId(id);

        Assertions.assertEquals(id, productEntity.getId());
    }

    @Test
    public void givenProductEntityWhenExternalIdSetThenExternalIdGetterReturnsSameValue() {
        UUID externalId = UUID.randomUUID();
        ProductEntity productEntity = new ProductEntity();

        productEntity.setExternalId(externalId);

        Assertions.assertEquals(externalId, productEntity.getExternalId());
    }

    @Test
    public void givenProductEntityWhenNameSetThenNameGetterReturnsSameValue() {
        String name = "ABC123";
        ProductEntity productEntity = new ProductEntity();

        productEntity.setName(name);

        Assertions.assertEquals(name, productEntity.getName());
    }
}
