package com.otymus.gestao_custos.entities.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record DespesaDTO(UUID id, String despesa, String categoria, LocalDate dataDespesa, BigDecimal valor) {
}
