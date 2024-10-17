package com.personaltrainerweb.personaltrainerweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.personaltrainerweb.personaltrainerweb.model.UsuarioCadastro;
import com.personaltrainerweb.personaltrainerweb.service.UsuarioCadastroService;

import java.util.List;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioCadastroService usuarioCadastroService;

    // Página inicial
    @GetMapping("/index")
    public String index() {
        return "index"; // Buscará o arquivo index.html em /src/main/resources/templates
    }

    // Página de cadastro
    @GetMapping("/cadastro")
    public String cadastro() {
        return "cadastro"; // Buscará o arquivo cadastro.html em /src/main/resources/templates
    }

    // Rota para cadastrar usuário
    @PostMapping("/cadastrarUsuario")
    @ResponseBody
    public UsuarioCadastro cadastrarUsuario(@RequestBody UsuarioCadastro usuario) {
        return usuarioCadastroService.cadastrarUsuario(usuario); // Salva o usuário no banco
    }

    // Rota para listar todos os usuários
    @GetMapping("/listarUsuarios")
    @ResponseBody
    public List<UsuarioCadastro> listarUsuarios() {
        return usuarioCadastroService.listarUsuarios(); // Retorna a lista de usuários
    }

    // Rota para login de usuário
    @PostMapping("/usuarios/login")
    public ResponseEntity<String> login(@RequestBody UsuarioCadastro usuario) {
        boolean autenticado = usuarioCadastroService.autenticar(usuario.getUsuario(), usuario.getSenha());

        if (autenticado) {
            return ResponseEntity.ok("Login realizado com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuário ou senha incorretos!");
        }
    }

    // Exemplo de funcionalidade existente (gerar treino)
    @GetMapping("/resultado")
    public String gerarTreino(
            @RequestParam String nome,
            @RequestParam String idade,
            @RequestParam String sexo,
            @RequestParam String biotipo,
            @RequestParam String dias,
            @RequestParam String tipoTreino,
            @RequestParam String objetivo,
            @RequestParam String nivel,
            Model model) {
        model.addAttribute("nome", nome);
        model.addAttribute("idade", idade);
        model.addAttribute("sexo", sexo);
        model.addAttribute("biotipo", biotipo);
        model.addAttribute("dias", dias);
        model.addAttribute("tipoTreino", tipoTreino);
        model.addAttribute("objetivo", objetivo);
        model.addAttribute("nivel", nivel);
        return "resultado"; // Nome do arquivo sem a extensão .html
    }
}