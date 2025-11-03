package com.otymus.gestao_custos.controller;

import com.otymus.gestao_custos.entities.dto.DespesaCadastroDTO;
import com.otymus.gestao_custos.entities.dto.DespesaDTO;
import com.otymus.gestao_custos.services.DespesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/despesa")
@RestController
public class DespesaController {
    @Autowired
    private DespesaService despesaService;

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody DespesaCadastroDTO despesaCadastroDTO) {
        try {
            var resultado = despesaService.salvar(despesaCadastroDTO);
            return ResponseEntity.ok(resultado);

        }catch (Exception e){
            return ResponseEntity.status(400).body(e.getMessage());
        }



    }

}
