package com.otymus.gestao_custos.performance;

import com.otymus.gestao_custos.entities.Despesa;
import com.otymus.gestao_custos.repositories.DespesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class DespesaSeeder implements CommandLineRunner {

    @Autowired
    private DespesaRepository despesaRepository;


    @Override
    public void run(String... args) throws Exception {
        System.out.println("Rodando junto com a aplicação");

        System.out.println("Iniciando geração de seed");
        List<Despesa> despesas = new ArrayList<>();
        for (int i = 1; i <= 150000; i++) {
            Despesa despesa = new Despesa();
            despesa.setDescricao("Despesa " + i);
            despesa.setDataDespesa(LocalDate.now().minusDays(i % 30));
            despesa.setValor(BigDecimal.valueOf(10 + (i % 50)));
            despesa.setCategoria("TESTE");
            despesa.setEmail("performance@gmail.com");

            despesas.add(despesa);
        }

        despesaRepository.saveAll(despesas);

        System.out.println("Finalizou geração de seed");
    }
}
