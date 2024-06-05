package com.dev.projeto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.projeto.modelos.Permissao;



public interface PermissaoRepositorio extends JpaRepository<Permissao, Long> {

}