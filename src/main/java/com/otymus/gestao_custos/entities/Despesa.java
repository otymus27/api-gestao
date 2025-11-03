package com.otymus.gestao_custos.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.CreatedDate;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "tb_despesa")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Despesa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String descricao;
    private LocalDate dataDespesa;
    private BigDecimal valor;
    private String categoria;
    @CreatedDate
    private LocalDate dataCriacao;
    private String email;

}
