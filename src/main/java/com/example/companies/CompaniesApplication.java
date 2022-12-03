package com.example.companies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CompaniesApplication {

    public static void main(String[] args) {
        SpringApplication.run(CompaniesApplication.class, args);
    }

}
