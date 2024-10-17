package com.personaltrainerweb.personaltrainerweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.personaltrainerweb.personaltrainerweb.model.UsuarioCadastro;

public interface UsuarioCadastroRepository extends JpaRepository<UsuarioCadastro, Long> {
    UsuarioCadastro findByUsuario(String usuario);
}