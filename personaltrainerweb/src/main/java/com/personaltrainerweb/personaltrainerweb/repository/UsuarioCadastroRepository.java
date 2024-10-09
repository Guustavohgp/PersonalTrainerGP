package com.personaltrainerweb.personaltrainerweb.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.personaltrainerweb.personaltrainerweb.model.UsuarioCadastro;

public interface UsuarioCadastroRepository extends JpaRepository<UsuarioCadastro, Long> {
    // Busca um usuário com base no nome de usuário
    Optional<UsuarioCadastro> findByUsuario(String usuario);
}