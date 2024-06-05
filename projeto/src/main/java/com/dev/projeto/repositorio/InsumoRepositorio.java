package com.dev.projeto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.projeto.modelos.Insumo;

public interface InsumoRepositorio extends JpaRepository<Insumo, Long> {

}
