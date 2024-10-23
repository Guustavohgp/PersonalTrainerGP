package com.personaltrainerweb.personaltrainerweb.service;

import com.personaltrainerweb.personaltrainerweb.model.Usuario; // ou Treino
import com.personaltrainerweb.personaltrainerweb.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Criar
    public Usuario salvarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // Ler
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    // Atualizar
    public Usuario atualizarUsuario(Long id, Usuario usuarioAtualizado) {
        Usuario usuarioExistente = usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        usuarioExistente.setIdade(usuarioAtualizado.getIdade());
        usuarioExistente.setSexo(usuarioAtualizado.getSexo());
        usuarioExistente.setBiotipo(usuarioAtualizado.getBiotipo());
        usuarioExistente.setTreino(usuarioAtualizado.getTreino());
        usuarioExistente.setExperiencia(usuarioAtualizado.getExperiencia());
        return usuarioRepository.save(usuarioExistente);
    }

    // Deletar
    public void deletarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
}