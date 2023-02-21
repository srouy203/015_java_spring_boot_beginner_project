package com.testing.cms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class CmssApplication {

    public static void main(String[] args) {
        SpringApplication.run(CmssApplication.class, args);
    }

}
