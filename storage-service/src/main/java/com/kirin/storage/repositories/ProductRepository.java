package com.kirin.storage.repositories;

import com.kirin.storage.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Склад пищевых продуктов
 */
public interface ProductRepository extends JpaRepository<Product, Long> {

}
