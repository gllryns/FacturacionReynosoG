package com.coder.facturacionreynosog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class FacturacionReynosoGApplication {

    public static void main(String[] args) {
        SpringApplication.run(FacturacionReynosoGApplication.class, args);
    }

    @GetMapping("/")
    public String home() {
        return "Hola tutor, hola mundo, este es el root de FacturacionReynosoGApplication";
    }
}
