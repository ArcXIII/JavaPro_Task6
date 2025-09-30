package org.arcsoft;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    public RestClient restTemplate(@Value("${user-service.base-url:http://localhost:8080/}") String baseUrl) {
        return RestClient.builder()
                .baseUrl(baseUrl)
                .build();
    }
}