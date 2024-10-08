package com.personaltrainerweb.personaltrainerweb.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.personaltrainerweb.personaltrainerweb.model.UsuarioCadastro;

public interface UsuarioCadastroRepository extends JpaRepository<UsuarioCadastro, Long> {
    Optional<UsuarioCadastro> findByUsername(String username);
}