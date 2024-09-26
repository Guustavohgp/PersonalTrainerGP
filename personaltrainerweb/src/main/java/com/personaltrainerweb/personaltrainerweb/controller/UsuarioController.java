package com.personaltrainerweb.personaltrainerweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class UsuarioController {

    @GetMapping("/index")
    public String index() {
        return "index"; // O Spring Boot vai buscar o arquivo index.html em /src/main/resources/templates
    }

    @GetMapping("/result")
    public String result() {
        return "result"; // O Spring Boot vai buscar o arquivo result.html em /src/main/resources/templates
    }
}