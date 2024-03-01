package com.kirin.web.services;

import com.kirin.web.records.Employee;
import com.kirin.web.records.Product;
import com.kirin.web.records.SemiFinishedProduct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

/**
 * Сервис для связи с api-gateway, получения запросов от подключенных к нему
 * микросервисов и обработки ответов от них
 */
@Service
@RequiredArgsConstructor
public class ClientService {

    /**
     * Ссылка для подключения к api-gateway
     */
    @Value("${gateway.uri}")
    private String gateway;

    /**
     * Объект RestClient для связи с api-gateway
     */
    private final RestClient client;
    // private final RestClient client = RestClient.create(); // without @Bean config

    /**
     * Тип отправляемых и получаемых через HTTP-запросы данных
     */
    private static final MediaType CONTENT_TYPE = MediaType.APPLICATION_JSON;

    /**
     * Получение списка всех продуктов на складе.
     * @return объект ResponseEntity со списком продуктов
     */
    public ResponseEntity<List<Product>> getListProductsInStorage() {
        return client.get()
                .uri(gateway + "/storage")
                .retrieve()
                // .body(new ParameterizedTypeReference<>() {}); // List<Product>
                .toEntity(new ParameterizedTypeReference<>() {});
    }

    /**
     * Добавление нового продукта на склад.
     * @param product запись с данными о новом продукте
     * @return объект ResponseEntity с полной информацией о добавленном продукте
     */
    public ResponseEntity<Product> addProductToStorage(Product product) {
        return client.post()
                .uri(gateway + "/storage/add")
                .contentType(CONTENT_TYPE)
                .body(product)
                .retrieve()
                .toEntity(Product.class);
                // .toBodilessEntity(); // не возвращать сущность + ResponseEntity<Void>
    }

    /**
     * Просмотр информации о группе продуктов на складе.
     * @param groupName название группы продуктов
     * @return объект ResponseEntity с данными для отображения
     */
    public ResponseEntity<String> getFoodGroupInfo(String groupName) {
        return client.get()
                .uri(gateway + "/storage/food-group?name=" + groupName)
                .retrieve()
                .toEntity(String.class);
    }

    /**
     * Получение списка всех полуфабрикатов на складе.
     * @return объект ResponseEntity со списком полуфабрикатов
     */
    public ResponseEntity<List<SemiFinishedProduct>> getListSemiFinishedProductsInStorage() {
        return client.get()
                .uri(gateway + "/kitchen")
                .retrieve()
                .toEntity(new ParameterizedTypeReference<>() {});
    }

    /**
     * Получение списка всех сотрудников из сервиса для работы с персоналом
     * @return объект ResponseEntity со списком сотрудников
     */
    public ResponseEntity<List<Employee>> getListEmployeesInPersonnel() {
        return client.get()
                .uri(gateway + "/personnel/list")
                .retrieve()
                .toEntity(new ParameterizedTypeReference<>() {});
    }
}
