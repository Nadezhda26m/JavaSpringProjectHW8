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

    /**
     * Репозиторий для работы с сущностями Product
     */
    private final ProductRepository repository;

    /**
     * Маппер сущностей
     */
    private final ModelMapper mapper;

    /**
     * Получение списка всех продуктов из репозитория.
     * @return список продуктов
     */
    public List<ProductResponse> getAllProducts() {
        return repository.findAll().stream()
                .map(product -> mapper.map(product, ProductResponse.class)).toList();
    }

    /**
     * Добавление нового продукта в репозиторий.
     * @param product объект ProductResponse с информацией о добавляемом продукте
     * @return объект ProductResponse со всеми полями
     */
    public ProductResponse addProduct(ProductResponse product) {
        product.setShelfLife(90); // TODO доделать расчет срока годности
        product.setIsInGoodCondition(true);
        Product product1 = mapper.map(product, Product.class);
        return mapper.map(repository.save(product1), ProductResponse.class);
    }


}
