package com.personaltrainerweb.personaltrainerweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.personaltrainerweb.personaltrainerweb.model.UsuarioCadastro;
import com.personaltrainerweb.personaltrainerweb.repository.UsuarioCadastroRepository;

@Service
public class UsuarioCadastroService {

    @Autowired
    private UsuarioCadastroRepository usuarioRepository;

    // Método para cadastrar usuário
    public UsuarioCadastro cadastrarUsuario(UsuarioCadastro usuario) {
        // Criptografa a senha antes de salvar
        usuario.setSenha(usuario.getSenha());
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

    // Método para deletar usuário pelo ID
    public void deletarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    // Método para autenticar usuário
    public boolean autenticar(String usuario, String senha) {
        UsuarioCadastro usuarioEncontrado = buscarPorUsuario(usuario);
        // Verifica se o usuário existe e se a senha corresponde
        return usuarioEncontrado != null && usuarioEncontrado.getSenha().equals(senha);
    }
}