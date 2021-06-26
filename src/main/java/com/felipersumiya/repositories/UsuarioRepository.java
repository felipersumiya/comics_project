package com.felipersumiya.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.felipersumiya.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
