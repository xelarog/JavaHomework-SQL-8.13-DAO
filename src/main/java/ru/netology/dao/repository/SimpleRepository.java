package ru.netology.dao.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.stream.Collectors;

public class SimpleRepository {
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

}
