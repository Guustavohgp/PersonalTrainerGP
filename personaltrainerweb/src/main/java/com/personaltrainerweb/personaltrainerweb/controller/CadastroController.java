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

    // Endpoint para cadastrar usuário
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

    // Endpoint para listar todos os usuários
    @GetMapping("/listar")
    public List<UsuarioCadastro> listarUsuarios() {
        return usuarioService.listarUsuarios();
    }

    // Endpoint para buscar usuário pelo nome de usuário
    @GetMapping("/buscar/{usuario}")
    public ResponseEntity<UsuarioCadastro> buscarPorUsuario(@PathVariable String usuario) {
        UsuarioCadastro usuarioEncontrado = usuarioService.buscarPorUsuario(usuario);
        if (usuarioEncontrado != null) {
            return ResponseEntity.ok(usuarioEncontrado);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // Endpoint para deletar usuário pelo ID
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable Long id) {
        if (usuarioService.buscarPorId(id) != null) {
            usuarioService.deletarUsuario(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // Endpoint para login
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UsuarioCadastro usuarioLogin) {
        // Lógica de autenticação
        UsuarioCadastro usuario = usuarioService.buscarPorUsuario(usuarioLogin.getUsuario());
        if (usuario != null && usuario.getSenha().equals(usuarioLogin.getSenha())) {
            // Aqui você pode gerar um token ou retornar uma mensagem de sucesso
            return ResponseEntity.ok("{\"message\":\"Login realizado com sucesso!\"}");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("{\"message\":\"Usuário ou senha incorretos!\"}");
        }
    }
}