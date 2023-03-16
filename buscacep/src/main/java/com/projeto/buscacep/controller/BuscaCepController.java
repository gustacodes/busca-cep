package com.projeto.buscacep.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.buscacep.model.Endereco;
import com.projeto.buscacep.service.ViaCepService;

@Controller
@RestController
public class BuscaCepController {
    
    @GetMapping("/busca/{cep}")
    public Endereco getEndereco(@PathVariable String cep) {

        ViaCepService buscaCep = new ViaCepService();
        Endereco endereco = new Endereco();

            try {
                try {
                    endereco = buscaCep.getEndereco(cep);
                }  catch (IOException e) {
                    
                    e.printStackTrace();
                }
            } catch (org.apache.hc.core5.http.ParseException e) {
                
                e.printStackTrace();
            }

        return endereco;
        
}
}
