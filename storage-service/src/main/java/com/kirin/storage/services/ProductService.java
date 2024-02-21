package com.kirin.storage.services;

import com.kirin.storage.models.Product;
import com.kirin.storage.repositories.ProductRepository;
import com.kirin.storage.response.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Сервис для работы с продуктами
 */
@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;

    private final ModelMapper mapper;

    public List<ProductResponse> getAllProducts() {
        return repository.findAll().stream()
                .map(product -> mapper.map(product, ProductResponse.class)).toList();
    }

    public ProductResponse addProduct(ProductResponse product) {
        Product product1 = mapper.map(product, Product.class);
        return mapper.map(repository.save(product1), ProductResponse.class);
    }


}
