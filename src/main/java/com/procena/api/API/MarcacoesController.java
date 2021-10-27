package com.procena.api.API;

import java.util.HashMap;
import java.util.List;

import com.procena.api.API.model.Marcacao;
import com.procena.api.API.repository.MarcacoesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class MarcacoesController {
    @Autowired
    private MarcacoesRepository marcacoesController;

    @GetMapping("/marcacao/{data}")
    public List<Marcacao> getMarcacoesByData(@PathVariable String data) {
        return marcacoesController.findByData(data);

    }

    @GetMapping("marcacao-mes/{mes}")
    public List<Marcacao> getMarcacoesByMonth(@PathVariable String mes) {
        return marcacoesController.findByMonth(mes);
    }

    @GetMapping("/marcacoes")
    public List<Marcacao> getCountries() {

        var marcacoes = (List<Marcacao>) marcacoesController.findAll();

        var params = new HashMap<String, Object>();
        params.put("countries", marcacoes);

        return marcacoes;
    }

    @PostMapping("/marcacao")
    public Marcacao marcarEvento(@RequestBody Marcacao novaMarcacao) {
        return marcacoesController.save(novaMarcacao);
    }

    @PutMapping("/marcacao/{id}")
    public Marcacao alterarMarcacao(@RequestBody Marcacao marcacao, @PathVariable Long id) {
        marcacao.setId(id);
        return marcacoesController.save(marcacao);
    }

    @DeleteMapping("/marcacao/{id}")
    public void deleteMarcacao(@PathVariable Long id) {
        marcacoesController.deleteById(id);
    }

}
