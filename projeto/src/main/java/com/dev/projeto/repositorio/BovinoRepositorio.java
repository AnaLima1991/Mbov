package com.dev.projeto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.projeto.modelos.Bovino;


public interface BovinoRepositorio extends JpaRepository<Bovino, Long> {

}
