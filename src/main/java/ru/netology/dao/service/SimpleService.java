package ru.netology.dao.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.dao.repository.SimpleRepository;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SimpleService {

    SimpleRepository repository;

    public String getProduct(String name) {
        return repository.getProductName(name);
    }

}
