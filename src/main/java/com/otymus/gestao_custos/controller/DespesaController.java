package com.otymus.gestao_custos.controller;

import com.otymus.gestao_custos.entities.dto.DespesaCadastroDTO;
import com.otymus.gestao_custos.services.DespesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/despesa")
@RestController
public class DespesaController {
    @Autowired
    private DespesaService despesaService;

    @PostMapping
    public void cadastrar(@RequestBody DespesaCadastroDTO despesaCadastroDTO) {
        despesaService.salvar(despesaCadastroDTO);
    }

}
