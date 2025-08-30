package com.zentra.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin(origins = "*")
public class ZentraApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZentraApiApplication.class, args);
    }
}