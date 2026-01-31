package org.incois.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class IncoisBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(IncoisBackendApplication.class, args);
    }
}
