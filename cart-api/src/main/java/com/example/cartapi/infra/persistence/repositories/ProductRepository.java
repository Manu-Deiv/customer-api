package com.example.cartapi.infra.persistence.repositories;

import com.example.cartapi.infra.persistence.models.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<ProductModel, UUID> {
    Optional<ProductModel> findByExternalId(UUID externalId);
}
