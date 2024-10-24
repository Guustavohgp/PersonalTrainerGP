package com.personaltrainerweb.personaltrainerweb.controller;

import com.personaltrainerweb.personaltrainerweb.model.Usuario;
import com.personaltrainerweb.personaltrainerweb.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/treinos")
public class TreinoController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/cadastrar") // Ajustado para o endpoint correto
    public ResponseEntity<Usuario> criarTreino(@RequestBody Usuario usuario) {
        Usuario novoUsuario = usuarioService.salvarUsuario(usuario); // Salva o treino como parte do usuário
        return ResponseEntity.status(HttpStatus.CREATED).body(novoUsuario);
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listarTreinos() {
        List<Usuario> usuarios = usuarioService.listarUsuarios(); // Listar todos os usuários (treinos)
        return ResponseEntity.ok(usuarios);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizarTreino(@PathVariable Long id, @RequestBody Usuario usuarioAtualizado) {
        Usuario usuario = usuarioService.atualizarUsuario(id, usuarioAtualizado); // Atualiza os dados do usuário
        return ResponseEntity.ok(usuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTreino(@PathVariable Long id) {
        usuarioService.deletarUsuario(id); // Deleta o usuário (ou treino)
        return ResponseEntity.noContent().build();
    }
}