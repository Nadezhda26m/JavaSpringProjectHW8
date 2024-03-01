package com.kirin.web.controllers;

import com.kirin.web.records.Product;
import com.kirin.web.services.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Контроллер для обработки запросов, приходящих на '/api'.
 */
@Controller
@RequestMapping("/api")
@RequiredArgsConstructor
public class WebController {

    /**
     * Сервис для связи с api-gateway
     */
    private final ClientService service;

    /**
     * Получение стартовой страницы приложения.
     * @return стартовая страница
     */
    @GetMapping()
    public String home() {
        return "home";
    }

    /**
     * Получение списка продуктов на складе для отображения.
     * @param model модель для передачи данных в представление
     * @return представление для отображения списка продуктов
     */
    @GetMapping("/storage-info")
    public String getAllProducts(Model model) {
        model.addAttribute("products", service.getListProductsInStorage().getBody());
        return "products-list";
    }

    /**
     * Получение информации о необходимых полях для добавления нового продукта.
     * @param product запись для хранения данных о продукте
     * @param model модель для передачи данных в представление
     * @return представление для заполнения информации о новом продукте
     */
    @GetMapping("/storage/add")
    public String addProductForm(Product product, Model model) {
        model.addAttribute("product", product);
        return "product-create";
    }

    /**
     * Отправка полученных из представления данных о новом продукте.
     * @param product запись для хранения данных о продукте
     * @param model модель для передачи данных в представление
     * @return перенаправление на страницу со списком продуктов
     */
    @PostMapping("/storage/add")
    public String addProduct(Product product, Model model) {
        service.addProductToStorage(product);
        return "redirect:/api/storage-info";
    }

    /**
     * Получение информации о группе продуктов со склада для отображения.
     * @param groupName параметр из адреса запроса, передающий название группы продуктов
     * @param model модель для передачи данных в представление
     * @return представление для отображения информации о группе пищевых продуктов
     */
    @GetMapping("/storage-info/food-group")
    public String showFoodGroup(@RequestParam("name") String groupName, Model model) {
        String foodGroup = service.getFoodGroupInfo(groupName).getBody();
        model.addAttribute("groupName", foodGroup);
        return "food-group-products";
    }

    /**
     * Получение списка полуфабрикатов со склада для отображения.
     * @param model модель для передачи данных в представление
     * @return представление для отображения списка полуфабрикатов
     */
    @GetMapping("/kitchen-info")
    public String getAllSemiFinishedProducts(Model model) {
        model.addAttribute("products",
                service.getListSemiFinishedProductsInStorage().getBody());
        return "semi-finished-products-list";
    }

    /**
     * Получение списка сотрудников из сервиса для работы с персоналом для отображения.
     * @param model модель для передачи данных в представление
     * @return представление для отображения списка сотрудников
     */
    @GetMapping("/staff")
    public String getAllEmployees(Model model) {
        model.addAttribute("employees",
                service.getListEmployeesInPersonnel().getBody());
        return "employees-list";
    }
}
