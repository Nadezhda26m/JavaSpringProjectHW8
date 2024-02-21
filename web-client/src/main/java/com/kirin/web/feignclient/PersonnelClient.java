package com.kirin.web.feignclient;

import com.kirin.web.models.Employee;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "personnel", url = "http://localhost:8085/personnel")
public interface PersonnelClient {

    @GetMapping("/list")
    ResponseEntity<List<Employee>> getAll();
}
