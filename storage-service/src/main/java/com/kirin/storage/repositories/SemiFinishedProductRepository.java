package com.kirin.storage.repositories;

import com.kirin.storage.models.SemiFinishedProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SemiFinishedProductRepository
        extends JpaRepository<SemiFinishedProduct, Long> {

}
