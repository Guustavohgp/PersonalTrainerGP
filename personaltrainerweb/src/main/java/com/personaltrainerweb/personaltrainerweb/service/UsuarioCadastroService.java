package com.personaltrainerweb.personaltrainerweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.personaltrainerweb.personaltrainerweb.model.UsuarioCadastro;
import com.personaltrainerweb.personaltrainerweb.repository.UsuarioCadastroRepository;

@Service
public class UsuarioCadastroService {

    @Autowired
    private UsuarioCadastroRepository usuarioCadastroRepository;

    // Método para cadastrar o usuário
    public boolean cadastrar(UsuarioCadastro usuarioCadastro) {
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

    // Método para autenticar o usuário
    public boolean autenticar(UsuarioCadastro usuarioCadastro) {
        // Tenta buscar o usuário pelo nome de usuário
        UsuarioCadastro usuarioSalvo = usuarioCadastroRepository.findByUsuario(usuarioCadastro.getUsuario()).orElse(null);

        // Verifica se o usuário foi encontrado e se a senha está correta
        if (usuarioSalvo != null && usuarioSalvo.getSenha().equals(usuarioCadastro.getSenha())) {
            return true;  // Autenticação bem-sucedida
        }
        return false;  // Falha na autenticação
    }
}