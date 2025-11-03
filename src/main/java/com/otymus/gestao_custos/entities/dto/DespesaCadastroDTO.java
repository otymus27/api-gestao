package com.otymus.gestao_custos.entities.dto;

import org.springframework.data.annotation.CreatedDate;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;


public record DespesaCadastroDTO(
        UUID id,
        String descricao,
        BigDecimal valor,
        LocalDate dataDespesa,
        String categoria,
        String email,
        @CreatedDate
        LocalDate dataCriacao
) {
}
