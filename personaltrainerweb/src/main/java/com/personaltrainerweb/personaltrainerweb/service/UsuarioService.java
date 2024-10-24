package com.personaltrainerweb.personaltrainerweb.service;

import com.personaltrainerweb.personaltrainerweb.model.Usuario; // ou Treino
import com.personaltrainerweb.personaltrainerweb.repository.UsuarioRepository; // ou TreinoRepository
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Criar um novo usuário ou treino
    public Usuario salvarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // Listar todos os usuários
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    // Atualizar um usuário existente
    public Usuario atualizarUsuario(Long id, Usuario usuarioAtualizado) {
        Usuario usuarioExistente = usuarioRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        usuarioExistente.setNome(usuarioAtualizado.getNome());
        usuarioExistente.setIdade(usuarioAtualizado.getIdade());
        usuarioExistente.setSexo(usuarioAtualizado.getSexo());
        usuarioExistente.setBiotipo(usuarioAtualizado.getBiotipo());
        usuarioExistente.setTreino(usuarioAtualizado.getTreino());
        usuarioExistente.setExperiencia(usuarioAtualizado.getExperiencia());
        usuarioExistente.setDias(usuarioAtualizado.getDias());
        return usuarioRepository.save(usuarioExistente);
    }

    // Deletar um usuário
    public void deletarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
}