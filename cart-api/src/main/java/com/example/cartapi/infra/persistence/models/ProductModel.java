package com.example.cartapi.infra.persistence.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name="products")
public class ProductModel implements Serializable {
    private static final long serialVersionID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(unique=true)
    private UUID externalId;
    @Column(unique=true)
    private String code;
    private BigDecimal value;

    public ProductModel(){}

    public ProductModel( UUID externalId, String code, BigDecimal value) {
        this.externalId = externalId;
        this.code = code;
        this.value = value;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public UUID getExternalId() {
        return externalId;
    }

    public void setExternalId(UUID externalId) {
        this.externalId = externalId;
    }
}
