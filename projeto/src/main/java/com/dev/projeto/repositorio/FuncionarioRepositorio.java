package com.dev.projeto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.projeto.modelos.Funcionario;

public interface FuncionarioRepositorio extends JpaRepository<Funcionario, Long> {

}
