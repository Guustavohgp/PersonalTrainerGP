package com.personaltrainerweb.personaltrainerweb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {
    @GetMapping("/")
    public String index() {
        return "index"; // O Spring Boot vai buscar o arquivo index.html em /src/main/resources/templates
    }

    // Mapeia a página de resultado (result.html)
    @GetMapping("/result")
    public String result() {
        return "result"; // O Spring Boot vai buscar o arquivo result.html em /src/main/resources/templates
    }
}

