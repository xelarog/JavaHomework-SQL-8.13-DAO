package ru.netology.dao.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.dao.service.SimpleService;

@RestController
public class SimpleController {

    SimpleService service;

    public SimpleController(SimpleService service) {
        this.service = service;
    }

    @GetMapping("/products/fetch-product")
    public String getProduct(@RequestParam("name") String name) {
        return service.getProduct(name);
    }

}
