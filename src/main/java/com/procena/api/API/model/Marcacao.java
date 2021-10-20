package com.procena.api.API.model;

import javax.persistence.*;

@Entity
@Table(name = "marcacoes")
public class Marcacao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String evento;
    private String data;
    private String hora;
    private String estado;

    public Marcacao() {
    }

    public Marcacao(String evento, String data, String hora, String estado) {
        this.evento = evento;
        this.data = data;
        this.hora = hora;
        this.estado = estado;
    }

    /**
     * @return Long return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return String return the evento
     */
    public String getEvento() {
        return evento;
    }

    /**
     * @param evento the evento to set
     */
    public void setEvento(String evento) {
        this.evento = evento;
    }

    /**
     * @return String return the data
     */
    public String getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * @return String return the hora
     */
    public String getHora() {
        return hora;
    }

    /**
     * @param hora the hora to set
     */
    public void setHora(String hora) {
        this.hora = hora;
    }

    /**
     * @return String return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

}