package com.example.cartapi.domain.dtos.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.UUID;

/**
 * Represents a data transfer object (DTO) for creating product records.
 * This DTO encapsulates information required to create a product, including external ID, name, value, and code.
 */
public record CreateProductRecordDTO(
        @NotBlank UUID externalID,
        @NotBlank String name,
        @NotNull BigDecimal value,
        @NotNull @NotBlank String code
) {
}
