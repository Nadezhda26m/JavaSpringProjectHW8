package com.kirin.storage.controllers;

import com.kirin.storage.response.ProductResponse;
import com.kirin.storage.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/storage")
@RequiredArgsConstructor
public class StorageController {

    private final ProductService service;

    @GetMapping()
    public ResponseEntity<List<ProductResponse>> getAll() {
        return ResponseEntity.ok().body(service.getAllProducts());
    }

    @PostMapping("/add")
    public ResponseEntity<ProductResponse> addProduct(@RequestBody ProductResponse product) {
        return ResponseEntity.ok().body(service.addProduct(product));
    }

    @GetMapping("/food-group")
    public ResponseEntity<String> showFoodGroup(@RequestParam("name") String groupName) {
        return ResponseEntity.ok().body(groupName + " ( from storage-service)");
    }
}
