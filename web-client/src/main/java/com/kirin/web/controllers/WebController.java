package com.kirin.web.controllers;

import com.kirin.web.models.Product;
import com.kirin.web.services.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/api")
@RequiredArgsConstructor
public class WebController {

    private final ClientService service;

    @GetMapping()
    public String home() {
        return "home";
    }

    @GetMapping("/storage-info")
    public String getAllProducts(Model model) {
        model.addAttribute("products", service.getListProductsInStorage());
        return "products-list";
    }

    @GetMapping("/storage/add")
    public String addProductForm(Product product, Model model) {
        model.addAttribute("product", product);
        return "product-create";
    }

    @PostMapping("/storage/add")
    public String addProduct(Product product, Model model) {
        service.addProductToStorage(product);
        return "redirect:/api/storage-info";
    }

    @GetMapping("/storage-info/food-group")
    public String showFoodGroup(@RequestParam("name") String groupName, Model model) {
        String foodGroup = service.getFoodGroupInfo(groupName);
        model.addAttribute("groupName", foodGroup);
        return "food-group-products";
    }

    @GetMapping("/kitchen-info")
    public String getAllSemiFinishedProducts(Model model) {
        model.addAttribute("products",
                service.getListSemiFinishedProductsInStorage());
        return "semi-finished-products-list";
    }

    @GetMapping("/staff")
    public String getAllEmployees(Model model) {
        model.addAttribute("employees",
                service.getListEmployeesInPersonnel());
        return "employees-list";
    }
}
