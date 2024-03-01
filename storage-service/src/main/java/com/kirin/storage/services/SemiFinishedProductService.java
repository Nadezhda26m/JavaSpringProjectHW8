package com.kirin.storage.services;

import com.kirin.storage.repositories.SemiFinishedProductRepository;
import com.kirin.storage.response.SemiFinishedProductResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Сервис для работы с полуфабрикатами
 */
@Service
@RequiredArgsConstructor
public class SemiFinishedProductService {

    /**
     * Репозиторий для работы с сущностями SemiFinishedProduct
     */
    private final SemiFinishedProductRepository repository;

    /**
     * Маппер сущностей
     */
    private final ModelMapper mapper;

    /**
     * Получение списка всех полуфабрикатов из репозитория.
     * @return список полуфабрикатов
     */
    public List<SemiFinishedProductResponse> getAllSemiFinishedProducts() {
        return repository.findAll().stream()
                .map(product -> mapper.map(
                        product, SemiFinishedProductResponse.class
                )).toList();
    }
}
