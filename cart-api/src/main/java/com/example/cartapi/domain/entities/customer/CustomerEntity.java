package com.example.cartapi.domain.entities.customer;

import java.util.UUID;

/**
 * Represents a customer entity.
 */
public class CustomerEntity {
    private UUID id;
    private UUID externalID;
    private String email;

    /**
     * Get the ID of the customer.
     * @return The ID of the customer.
     */
    public UUID getId() {
        return id;
    }

    /**
     * Set the ID of the customer.
     * @param id The ID to set.
     */
    public void setId(UUID id) {
        this.id = id;
    }

    /**
     * Get the external ID of the customer.
     * @return The external ID of the customer.
     */
    public UUID getExternalID() {
        return externalID;
    }

    /**
     * Set the external ID of the customer.
     * @param externalID The external ID to set.
     */
    public void setExternalID(UUID externalID) {
        this.externalID = externalID;
    }

    /**
     * Get the email of the customer.
     * @return The email of the customer.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set the email of the customer.
     * @param email The email to set.
     */
    public void setEmail(String email) {
        this.email = email;
    }
}
