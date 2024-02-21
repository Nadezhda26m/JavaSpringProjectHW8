package com.kirin.web.feignclient;

import com.kirin.web.models.SemiFinishedProduct;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "productStorage2", url = "http://localhost:8085/kitchen")
public interface KitchenClient {

    @GetMapping()
    ResponseEntity<List<SemiFinishedProduct>> getAll();
}
