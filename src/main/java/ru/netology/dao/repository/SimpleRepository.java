package ru.netology.dao.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import ru.netology.dao.entity.Customers;
import ru.netology.dao.entity.Orders;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SimpleRepository {

    @PersistenceContext
    private EntityManager entityManager;
    private String sqlRequest;
    private final String scriptFileName = "request.sql";

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public SimpleRepository() {
        sqlRequest = read(scriptFileName);
    }

    private static String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getProductName(String name) {
        sqlRequest = read(scriptFileName);
        return namedParameterJdbcTemplate.queryForList(sqlRequest, Map.of("name", name)).toString();
    }

    @Transactional
    public void createTable() {

        Customers[] customers = {
                new Customers("Alex", "Petrov", 23, "5465465321"),
                new Customers("Petr", "Sidorov", 35, "65465456454"),
                new Customers("Ivan", "Lebedev", 43, "8879879878"),
                new Customers("Roman", "Frolov", 16, "2223321321"),
                new Customers("Irina", "Egorova", 28, "54657887987")
        };

        for (Customers entity : customers) {
            entityManager.persist(entity);
        }

        List<Orders> ordersList = List.of(
                new Orders("2022-09-13", customers[1], "tv", 1),
                new Orders("2022-09-22", customers[0], "notebook", 1),
                new Orders("2022-10-01", customers[4], "smartphone", 1),
                new Orders("2022-10-15", customers[3], "cpu", 1),
                new Orders("2022-10-23", customers[2], "ram", 2),
                new Orders("2022-10-30", customers[1], "ssd", 2),
                new Orders("2022-11-05", customers[2], "motherboard", 1),
                new Orders("2022-11-12", customers[3], "graphics card", 1),
                new Orders("2022-11-16", customers[0], "mouse", 2),
                new Orders("2022-11-18", customers[1], "keyboard", 1)
        );

        for (Orders entity : ordersList) {
            entityManager.persist(entity);
        }
    }
}
