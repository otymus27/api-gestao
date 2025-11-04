package com.otymus.gestao_custos.repositories;

import com.otymus.gestao_custos.entities.Despesa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface DespesaRepository  extends JpaRepository<Despesa, UUID> {


    List<Despesa> findByEmail(String email);

    List<Despesa> findByEmailAndDataDespesa(String email,LocalDate dataDespesa);
}