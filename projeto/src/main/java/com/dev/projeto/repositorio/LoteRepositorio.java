package com.dev.projeto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.projeto.modelos.Lote;



public interface LoteRepositorio extends JpaRepository<Lote, Long> {

}
