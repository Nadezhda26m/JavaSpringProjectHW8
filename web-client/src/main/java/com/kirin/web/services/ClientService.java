package com.kirin.web.services;

import com.kirin.web.models.Employee;
import com.kirin.web.models.Product;
import com.kirin.web.models.SemiFinishedProduct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {

    @Value("${gateway.uri}")
    private String gateway;

    private final RestClient client;
    // private final RestClient client = RestClient.create(); // without @Bean config

    private static final MediaType CONTENT_TYPE = MediaType.APPLICATION_JSON;

    public ResponseEntity<List<Product>> getListProductsInStorage() {
        return client.get()
                .uri(gateway + "/storage")
                .retrieve()
                // .body(new ParameterizedTypeReference<>() {}); // List<Product>
                .toEntity(new ParameterizedTypeReference<>() {});
    }

    public ResponseEntity<Product> addProductToStorage(Product product) {
        return client.post()
                .uri(gateway + "/storage/add")
                .contentType(CONTENT_TYPE)
                .body(product)
                .retrieve()
                .toEntity(Product.class);
                // .toBodilessEntity(); // не возвращать сущность + ResponseEntity<Void>
    }

    public ResponseEntity<String> getFoodGroupInfo(String groupName) {
        return client.get()
                .uri(gateway + "/storage/food-group?name=" + groupName)
                .retrieve()
                .toEntity(String.class);
    }

    public ResponseEntity<List<SemiFinishedProduct>> getListSemiFinishedProductsInStorage() {
        return client.get()
                .uri(gateway + "/kitchen")
                .retrieve()
                .toEntity(new ParameterizedTypeReference<>() {});
    }

    public ResponseEntity<List<Employee>> getListEmployeesInPersonnel() {
        return client.get()
                .uri(gateway + "/personnel/list")
                .retrieve()
                .toEntity(new ParameterizedTypeReference<>() {});
    }
}
