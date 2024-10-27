package com.personaltrainerweb.personaltrainerweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.Optional;
import com.personaltrainerweb.personaltrainerweb.model.UsuarioCadastro;
import com.personaltrainerweb.personaltrainerweb.repository.UsuarioCadastroRepository;

@Service
public class UsuarioCadastroService {

    @Autowired
    private UsuarioCadastroRepository usuarioRepository;

    // Método para cadastrar usuário
    public UsuarioCadastro cadastrarUsuario(UsuarioCadastro usuario) {
        // Verifica se o usuário já existe
        if (usuarioRepository.findByUsuario(usuario.getUsuario()) != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuário já cadastrado");
        }

        // Não há mais criptografia (conforme sua solicitação)
        return usuarioRepository.save(usuario);
    }

    // Método para listar todos os usuários
    public List<UsuarioCadastro> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    // Método para buscar usuário pelo nome de usuário
    public UsuarioCadastro buscarPorUsuario(String usuario) {
        return usuarioRepository.findByUsuario(usuario);
    }

    // Método para buscar usuário pelo ID
    public UsuarioCadastro buscarPorId(Long id) {
        Optional<UsuarioCadastro> usuario = usuarioRepository.findById(id);
        return usuario.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado"));
    }

    // Método para deletar usuário pelo ID
    public void deletarUsuario(Long id) {
        if (!usuarioRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado");
        }
        usuarioRepository.deleteById(id);
    }

    // Método para autenticar usuário
    public boolean autenticar(String usuario, String senha) {
        UsuarioCadastro usuarioEncontrado = buscarPorUsuario(usuario);
        // Verifica se o usuário existe e se a senha corresponde
        return usuarioEncontrado != null && usuarioEncontrado.getSenha().equals(senha);
    }
}