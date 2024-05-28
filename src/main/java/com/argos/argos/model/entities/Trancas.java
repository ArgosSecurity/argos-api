package com.argos.argos.model.entities;

import jakarta.persistence.*;

@Entity
public class Trancas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long idRegistroTranca;

    private String localidade;

    public Trancas() {}

    public Trancas(Long idRegistroTranca, String localidades) {
        this.idRegistroTranca = idRegistroTranca;
        this.localidade = localidade;
    }

    public Long getId() {
        return id;
    }

    public Long getIdRegistroTranca() {
        return idRegistroTranca;
    }

    public void setIdRegistroTranca(Long idRegistroTranca) {
        this.idRegistroTranca = idRegistroTranca;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }
}
