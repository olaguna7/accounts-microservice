package com.oscar.accountsmicroservice;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(
        info = @Info(
                title = "Accounts microservice REST API documentation",
                description = "Bank accounts microservice REST API documentation",
                version = "v1",
                contact = @Contact(
                        name = "Óscar Laguna",
                        email = "oscarlagunacaminero@gmail.com"
                )
        )
)
public class AccountsMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountsMicroserviceApplication.class, args);
    }

}
