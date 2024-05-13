package com.example.cartapi.domain.dtos.cart;

import com.example.cartapi.domain.entities.product.ProductEntity;

import java.util.List;
import java.util.UUID;

/**
 * Represents a data transfer object (DTO) for creating cart records.
 * This DTO encapsulates information required to create a cart, including customer ID and list of external id.
 */
public record CreateCartRecordDto(UUID customerId, List<UUID> externalIds) {}