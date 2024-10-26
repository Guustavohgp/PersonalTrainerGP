package com.personaltrainerweb.personaltrainerweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.personaltrainerweb.personaltrainerweb.model.UsuarioCadastro;
import com.personaltrainerweb.personaltrainerweb.service.UsuarioCadastroService;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class CadastroController {

    @Autowired
    private UsuarioCadastroService usuarioService;

    @PostMapping("/cadastrar")
    public ResponseEntity<String> cadastrarUsuario(@RequestBody UsuarioCadastro usuario) {
        // Verifica se o usuário já existe
        if (usuarioService.buscarPorUsuario(usuario.getUsuario()) != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("{\"message\":\"Usuário já cadastrado!\"}");
        }

        usuarioService.cadastrarUsuario(usuario);
        return ResponseEntity.ok("{\"message\":\"Usuário cadastrado com sucesso!\"}");
    }

    @GetMapping("/listar")
    public List<UsuarioCadastro> listarUsuarios() {
        return usuarioService.listarUsuarios();
    }

    @GetMapping("/buscar/{usuario}")
    public UsuarioCadastro buscarPorUsuario(@PathVariable String usuario) {
        return usuarioService.buscarPorUsuario(usuario);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarUsuario(@PathVariable Long id) {
        usuarioService.deletarUsuario(id);
    }
}