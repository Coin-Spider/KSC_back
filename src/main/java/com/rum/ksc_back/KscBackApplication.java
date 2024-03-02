package com.rum.ksc_back;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class KscBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(KscBackApplication.class, args);
    }

}
