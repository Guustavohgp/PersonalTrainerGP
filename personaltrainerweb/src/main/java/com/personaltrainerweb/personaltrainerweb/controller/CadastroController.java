package com.personaltrainerweb.personaltrainerweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.personaltrainerweb.personaltrainerweb.model.UsuarioCadastro; // Certifique-se de que este é o nome correto da sua classe model
import com.personaltrainerweb.personaltrainerweb.service.UsuarioCadastroService;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class CadastroController {

    @Autowired
    private UsuarioCadastroService usuarioService;

    @PostMapping("/cadastrar")
    public UsuarioCadastro cadastrarUsuario(@RequestBody UsuarioCadastro usuario) {
        return usuarioService.cadastrarUsuario(usuario);
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