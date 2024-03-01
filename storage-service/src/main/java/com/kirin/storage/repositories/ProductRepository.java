package com.kirin.storage.repositories;

import com.kirin.storage.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Репозиторий для работы с сущностью Product (склад пищевых продуктов)
 */
public interface ProductRepository extends JpaRepository<Product, Long> {

}
