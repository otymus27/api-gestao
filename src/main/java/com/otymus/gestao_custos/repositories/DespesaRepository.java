package com.otymus.gestao_custos.repositories;

import com.otymus.gestao_custos.entities.Despesa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DespesaRepository  extends JpaRepository<Despesa, UUID> {
}