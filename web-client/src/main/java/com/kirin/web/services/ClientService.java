package com.kirin.web.services;

import com.kirin.web.feignclient.KitchenClient;
import com.kirin.web.feignclient.PersonnelClient;
import com.kirin.web.feignclient.StorageClient;
import com.kirin.web.models.Employee;
import com.kirin.web.models.Product;
import com.kirin.web.models.SemiFinishedProduct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final StorageClient storageClient;

    private final KitchenClient kitchenClient;

    private final PersonnelClient personnelClient;

    public List<Product> getListProductsInStorage() {
        return storageClient.getAll().getBody();
    }

    public Product addProductToStorage(Product product) {
        return storageClient.addProduct(product).getBody();
    }

    public String getFoodGroupInfo(String groupName) {
        return storageClient.showFoodGroup(groupName).getBody();
    }

    public List<SemiFinishedProduct> getListSemiFinishedProductsInStorage() {
        return kitchenClient.getAll().getBody();
    }

    public List<Employee> getListEmployeesInPersonnel() {
        return personnelClient.getAll().getBody();
    }
}
