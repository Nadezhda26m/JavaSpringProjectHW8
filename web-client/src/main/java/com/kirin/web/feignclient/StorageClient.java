package com.kirin.web.feignclient;

import com.kirin.web.models.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "productStorage", url = "http://localhost:8085/storage")
public interface StorageClient {

    @GetMapping()
    ResponseEntity<List<Product>> getAll();

    @PostMapping("/add")
    ResponseEntity<Product> addProduct(@RequestBody Product product);

    @GetMapping("/food-group")
    ResponseEntity<String> showFoodGroup(@RequestParam("name") String groupName);
}
