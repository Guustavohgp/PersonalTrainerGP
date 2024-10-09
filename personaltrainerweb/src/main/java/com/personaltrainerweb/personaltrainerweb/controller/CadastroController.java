package com.personaltrainerweb.personaltrainerweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.personaltrainerweb.personaltrainerweb.model.UsuarioCadastro;
import com.personaltrainerweb.personaltrainerweb.repository.UsuarioCadastroRepository;

@RestController
@RequestMapping("/api/usuarios")
public class CadastroController {

    @Autowired
    private UsuarioCadastroRepository usuarioCadastroRepository;

    // Método para cadastrar o usuário
    public boolean cadastrar(UsuarioCadastro usuarioCadastro) {
        // Verifica se o usuário já existe
        if (usuarioCadastroRepository.findByUsuario(usuarioCadastro.getUsuario()).isPresent()) {
            return false;  // Usuário já existe
        }
        usuarioCadastroRepository.save(usuarioCadastro); // Salva o novo usuário
        return true;
    }

    // Método para verificar se o nome de usuário já está em uso
    public boolean isUsuarioAvailable(String usuario) {
        return usuarioCadastroRepository.findByUsuario(usuario).isEmpty();  // Verifica se o usuário existe
    }
}