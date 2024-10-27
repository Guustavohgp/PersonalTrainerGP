package com.personaltrainerweb.personaltrainerweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.personaltrainerweb.personaltrainerweb.model.UsuarioCadastro;
import com.personaltrainerweb.personaltrainerweb.service.UsuarioCadastroService;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioCadastroService usuarioCadastroService;

    // Página inicial
    @GetMapping("/index")
    public String index() {
        return "index";
    }

    // Página de cadastro
    @GetMapping("/cadastro")
    public String cadastro() {
        return "cadastro";
    }

    // Página de treino
    @GetMapping("/treino")
    public String treino() {
        return "treino";
    }

    @GetMapping("/meustreinos")
    public String meustreinos() {
        return "meustreinos";
    }

    @GetMapping("/pagina")
    public String pagina() {
        return "pagina";
    }

    // Rota para autenticar login
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UsuarioCadastro usuario) {
        boolean autenticado = usuarioCadastroService.autenticar(usuario.getUsuario(), usuario.getSenha());

        if (autenticado) {
            return ResponseEntity.ok("{\"message\":\"Login realizado com sucesso!\"}");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("{\"message\":\"Usuário ou senha incorretos!\"}");
        }
    }

    @GetMapping("/resultado")
    public String gerarTreino(
            @RequestParam String nome,
            @RequestParam String idade,
            @RequestParam String sexo,
            @RequestParam String biotipo,
            @RequestParam String dias,
            @RequestParam String treino,
            @RequestParam String experiencia,
            Model model) {
        // Adiciona os parâmetros ao modelo
        model.addAttribute("nome", nome);
        model.addAttribute("idade", idade);
        model.addAttribute("sexo", sexo);
        model.addAttribute("biotipo", biotipo);
        model.addAttribute("dias", dias);
        model.addAttribute("treino", treino);
        model.addAttribute("experiencia", experiencia);
        return "resultado";
    }
}