package com.procena.api.API.repository;

import java.util.List;

import com.procena.api.API.model.Marcacao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MarcacoesRepository extends CrudRepository<Marcacao, Long> {
    List<Marcacao> findAll();

    @Query(value = "SELECT * FROM dbo.marcacoes where data = :data", nativeQuery = true)
    public List<Marcacao> findByData(@Param("data") String data);

    @Query(value = "SELECT * FROM dbo.marcacoes where MONTH(data) = :mes", nativeQuery = true)
    public List<Marcacao> findByMonth(@Param("mes") String mes);

}