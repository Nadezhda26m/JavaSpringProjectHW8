package com.kirin.storage.controllers;

import com.kirin.storage.response.SemiFinishedProductResponse;
import com.kirin.storage.services.SemiFinishedProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/kitchen")
@RequiredArgsConstructor
public class KitchenController {

    private final SemiFinishedProductService service;

    @GetMapping()
    public ResponseEntity<List<SemiFinishedProductResponse>> getAll() {
        return ResponseEntity.ok().body(service.getAllSemiFinishedProducts());
    }
}
