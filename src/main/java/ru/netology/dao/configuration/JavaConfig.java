package ru.netology.dao.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.netology.dao.repository.SimpleRepository;
import ru.netology.dao.service.SimpleService;

@Configuration
public class JavaConfig {

    @Bean
    public SimpleService service(SimpleRepository repository) {
        return new SimpleService(repository);
    }

    @Bean
    public SimpleRepository repository() {
        return new SimpleRepository();
    }

}
