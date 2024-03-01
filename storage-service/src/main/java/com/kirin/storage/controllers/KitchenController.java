package com.kirin.storage.controllers;

import com.kirin.storage.response.SemiFinishedProductResponse;
import com.kirin.storage.services.SemiFinishedProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Контроллер для обработки запросов, приходящих на '/kitchen'.
 */
@RestController
@RequestMapping("/kitchen")
@RequiredArgsConstructor
public class KitchenController {

    /**
     * Сервис для работы с полуфабрикатами
     */
    private final SemiFinishedProductService service;

    /**
     * Получение списка всех полуфабрикатов.
     * @return объект ResponseEntity со списком полуфабрикатов
     */
    @GetMapping()
    public ResponseEntity<List<SemiFinishedProductResponse>> getAll() {
        return ResponseEntity.ok().body(service.getAllSemiFinishedProducts());
    }
}
