package com.kirin.storage.controllers;

import com.kirin.storage.response.ProductResponse;
import com.kirin.storage.services.ProductService;
import com.kirin.storage.services.integration.FileGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Контроллер для обработки запросов, приходящих на '/storage'.
 */
@RestController
@RequestMapping("/storage")
@RequiredArgsConstructor
public class StorageController {

    /**
     * Сервис для работы с данными о продуктах и сырье на складе
     */
    private final ProductService service;

    /**
     * Поток интеграции для записи в файл
     */
    private final FileGateway fileGateway;

    /**
     * Получение списка всех продуктов.
     * @return объект ResponseEntity со списком продуктов
     */
    @GetMapping()
    public ResponseEntity<List<ProductResponse>> getAll() {
        return ResponseEntity.ok().body(service.getAllProducts());
    }

    /**
     * Добавление нового продукта. Фиксация в файле информации о добавленном продукте.
     * @param product объект с данными, необходимыми для добавления нового продукта.
     * @return объект ResponseEntity с полной информацией о добавленном продукте
     */
    @PostMapping("/add")
    public ResponseEntity<ProductResponse> addProduct(@RequestBody ProductResponse product) {
        ProductResponse productResponse = service.addProduct(product);
        fileGateway.writeToFile("storage-add.txt", productResponse);
        return ResponseEntity.ok().body(productResponse);
    }

    /**
     * Просмотр информации о группе продуктов.
     * @param groupName название группы продуктов
     * @return объект ResponseEntity с данными для отображения
     */
    @GetMapping("/food-group")
    public ResponseEntity<String> showFoodGroup(@RequestParam("name") String groupName) {
        return ResponseEntity.ok().body(groupName + " (from storage-service)");
    }
}
