package com.oscar.accountsmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
public class AccountsMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountsMicroserviceApplication.class, args);
    }

}
