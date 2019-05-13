package com.thalles.teste.stock.auth.authservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thalles.teste.stock.auth.authservice.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, String>{

}
