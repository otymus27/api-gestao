package com.otymus.gestao_custos.controller;

import com.otymus.gestao_custos.entities.Despesa;
import com.otymus.gestao_custos.entities.dto.DespesaCadastroDTO;
import com.otymus.gestao_custos.repositories.DespesaRepository;
import com.otymus.gestao_custos.services.DespesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@RequestMapping("/api/despesa")
@RestController
public class DespesaController {
    @Autowired
    private DespesaService despesaService;
    @Autowired
    private DespesaRepository despesaRepository;

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody DespesaCadastroDTO despesaCadastroDTO) {
        try {
            var resultado = despesaService.salvar(despesaCadastroDTO);
            return ResponseEntity.ok(resultado);

        }catch (Exception e){
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @GetMapping
    public List<Despesa> listar() {
        return despesaService.listar();
    }

    @GetMapping("sem-paginacao")
    public ResponseEntity<List<Despesa>> listarSemPaginacao() {
        long inicio = System.currentTimeMillis();
        var despesas = despesaRepository.findAll();
        long fim = System.currentTimeMillis();
        System.out.printf("Tempo: %d ms", fim - inicio);
        return ResponseEntity.ok(despesas);
    }

    @GetMapping("com-paginacao")
    public ResponseEntity<Page<Despesa>> listarComPaginacao(Pageable pageable) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        var despesas = despesaRepository.findAll(pageable);
        stopWatch.stop();
        System.out.printf("Tempo (com paginação): ms" + stopWatch.getTotalTimeMillis() + " ms");
        return ResponseEntity.ok(despesas);
    }

    @GetMapping("/buscar/{email}")
    public List<Despesa> buscarPorEmailEData(@PathVariable String email, @RequestParam(required=false) LocalDate dataDespesa) {
//        System.out.println(email);
//        System.out.println(dataDespesa);
        return despesaService.buscarPorEmailEData(email, dataDespesa);
    }
}
