package ru.netology.dao.service;

import ru.netology.dao.repository.SimpleRepository;

public class SimpleService {

    SimpleRepository repository;

    public SimpleService(SimpleRepository repository) {
        this.repository = repository;
    }

    public String getProduct(String name) {
        return repository.getProductName(name);
    }

}
