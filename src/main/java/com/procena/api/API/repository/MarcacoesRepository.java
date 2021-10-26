package com.procena.api.API.repository;
import java.util.List;

import com.procena.api.API.model.Marcacao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarcacoesRepository extends CrudRepository <Marcacao, Long> {
    List <Marcacao> findAll();
    
}