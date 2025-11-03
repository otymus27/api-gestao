package com.otymus.gestao_custos.services;

import com.otymus.gestao_custos.entities.Despesa;
import com.otymus.gestao_custos.entities.dto.DespesaCadastroDTO;
import com.otymus.gestao_custos.entities.dto.DespesaDTO;
import com.otymus.gestao_custos.repositories.DespesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;


@Service
public class DespesaService {

    @Autowired
    private final DespesaRepository despesaRepository;

    public DespesaService(DespesaRepository despesaRepository) {
        this.despesaRepository = despesaRepository;
    }




    public DespesaDTO salvar(DespesaCadastroDTO dto) {
        Despesa despesa = new Despesa();

        despesa.setDescricao(dto.descricao());
        despesa.setValor(dto.valor());
        despesa.setDataDespesa(dto.dataDespesa());
        despesa.setCategoria(dto.categoria());
        despesa.setEmail(dto.email());
        despesa.setDataCriacao(LocalDate.now());

        if (despesa.getDescricao() == null || despesa.getValor() == null || despesa.getDataDespesa() == null) {
            throw new IllegalArgumentException("Preencher todos os campos");
        }

        System.out.println("Antes de salvar");
        System.out.println(despesa);

        despesaRepository.save(despesa);
        System.out.println("Antes de salvar");
        System.out.println(despesa);
        return new DespesaDTO(despesa.getId(),despesa.getDescricao(),despesa.getCategoria(),despesa.getDataDespesa(), despesa.getValor());

    }
}
