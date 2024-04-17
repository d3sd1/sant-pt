package com.sant.santpt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class SantPtApplication {

    public static void main(String[] args) {
        SpringApplication.run(SantPtApplication.class, args);
    }

}
