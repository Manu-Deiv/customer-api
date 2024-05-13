package com.example.cartapi.domain.gateways.useCases.cart;

import com.example.cartapi.domain.dtos.cart.CreateCartRecordDto;
import com.example.cartapi.domain.dtos.ResponseRecordDTO;
import com.example.cartapi.domain.entities.CartEntity;

public interface CreateCartUseCaseInterface {
    public CartEntity execute(CreateCartRecordDto createCartRecordDto);
}
