package com.example.cartapi.domain.dtos.customer;

import java.util.UUID;

/**
 * Represents a data transfer object (DTO) for creating customer records.
 * This DTO encapsulates information required to create a customer, including ID, external ID, and email.
 */
public record CreateCustomerRecordDTO(
        UUID id,
        UUID externalID,
        String email
) {
}
