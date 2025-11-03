package com.otymus.gestao_custos;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/javadev")
@RestController
public class PrimeiraController {

    @GetMapping("/olamundo")
    public String helloWorld(){
        return "Olá Mundo, este é meu primeiro controller";
    }
}
