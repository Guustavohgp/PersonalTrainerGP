package com.personaltrainerweb.personaltrainerweb.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class UsuarioController {
    @GetMapping("/usuarios")
    public String texto () {
        return "Acessando a API";
    }
    
}
