package com.kirin.storage.services;

import com.kirin.storage.repositories.SemiFinishedProductRepository;
import com.kirin.storage.response.SemiFinishedProductResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SemiFinishedProductService {

    private final SemiFinishedProductRepository repository;

    private final ModelMapper mapper;

    public List<SemiFinishedProductResponse> getAllSemiFinishedProducts() {
        return repository.findAll().stream()
                .map(product -> mapper.map(
                        product, SemiFinishedProductResponse.class
                )).toList();
    }
}
