package com.example.cartapi.domain.entities.cart;

import com.example.cartapi.domain.entities.CartEntity;
import com.example.cartapi.domain.entities.product.ProductEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.UUID;

public class CartEntityTest {

    @Test
    public void givenCartEntityWhenIdSetThenIdGetterReturnsSameValue() {
        UUID id = UUID.randomUUID();
        CartEntity cartEntity = new CartEntity();

        cartEntity.setId(id);

        Assertions.assertEquals(id, cartEntity.getId());
    }

    @Test
    public void givenCartEntityWhenCustomerIdSetThenCustomerIdGetterReturnsSameValue() {
        UUID customerId = UUID.randomUUID();
        CartEntity cartEntity = new CartEntity();

        cartEntity.setCustomerId(customerId);

        Assertions.assertEquals(customerId, cartEntity.getCustomerId());
    }

    @Test
    public void givenCartEntityWhenProductAddedThenProductListContainsProduct() {
        CartEntity cartEntity = new CartEntity();
        ProductEntity product = new ProductEntity();

        cartEntity.addProduct(product);

        Assertions.assertTrue(cartEntity.getProducts().contains(product));
    }

    @Test
    public void givenCartEntityWithProductWhenProductRemovedThenProductListDoesNotContainProduct() {
        CartEntity cartEntity = new CartEntity();
        ProductEntity product = new ProductEntity();
        cartEntity.addProduct(product);

        cartEntity.removeProduct(product);

        Assertions.assertFalse(cartEntity.getProducts().contains(product));
    }

    @Test
    public void givenCartEntityWithProductsWhenProductsClearedThenProductListIsEmpty() {
        CartEntity cartEntity = new CartEntity();
        ProductEntity product1 = new ProductEntity();
        ProductEntity product2 = new ProductEntity();
        cartEntity.addProduct(product1);
        cartEntity.addProduct(product2);

        cartEntity.clearProducts();

        Assertions.assertTrue(cartEntity.getProducts().isEmpty());
    }
}
