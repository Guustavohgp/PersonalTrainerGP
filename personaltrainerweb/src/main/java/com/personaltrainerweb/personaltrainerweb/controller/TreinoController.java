package com.personaltrainerweb.personaltrainerweb.controller;

import com.personaltrainerweb.personaltrainerweb.model.Usuario; // ou Treino
import com.personaltrainerweb.personaltrainerweb.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/treinos") 
public class TreinoController {

    @Autowired
    private UsuarioService usuarioService;

    // Criar
    @PostMapping("/cadastrar")
    public Usuario cadastrarTreino(@RequestBody Usuario usuario) { 
        return usuarioService.salvarUsuario(usuario);
    }

    // Ler
    @GetMapping("/listar")
    public List<Usuario> listarTreinos() {
        return usuarioService.listarUsuarios();
    }

    // Atualizar
    @PutMapping("/atualizar/{id}")
    public Usuario atualizarTreino(@PathVariable Long id, @RequestBody Usuario usuario) { 
        return usuarioService.atualizarUsuario(id, usuario);
    }

    // Deletar
    @DeleteMapping("/deletar/{id}")
    public void deletarTreino(@PathVariable Long id) {
        usuarioService.deletarUsuario(id);
    }
}