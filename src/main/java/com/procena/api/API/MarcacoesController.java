package com.procena.api.API;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;

import com.procena.api.API.model.Marcacao;
import com.procena.api.API.repository.MarcacoesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class MarcacoesController {
    @Autowired
    private MarcacoesRepository marcacoesController;

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:s");
        DateTimeFormatter hourFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:s");
        LocalDateTime data = LocalDateTime.now();
        String evento = "Teste de Salvacao";
        String estado = "novo";
        Marcacao novaMarcacao = new Marcacao(evento, dateFormat.format(data), hourFormat.format(data), estado);

        marcacoesController.save(novaMarcacao);
        return String.format("Hello %s!", name);
    }

    @GetMapping("/marcacoes")
    public List<Marcacao> getCountries() {

        var marcacoes = (List<Marcacao>) marcacoesController.findAll();

        var params = new HashMap<String, Object>();
        params.put("countries", marcacoes);

        return marcacoes;
    }
}