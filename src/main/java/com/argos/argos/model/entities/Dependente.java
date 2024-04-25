package com.argos.argos.model.entities;

import jakarta.persistence.*;

@Entity
public class Dependente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String rg;
    private String apto;

    @ManyToOne
    @JoinColumn(name = "idResponsavel", referencedColumnName = "id")
    private Responsavel responsavel;

    public Dependente(){}

    public Dependente(String nome, String rg, String apto, Responsavel responsavel) {
        this.nome = nome;
        this.rg = rg;
        this.apto = apto;
        this.responsavel = responsavel;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getApto() {
        return apto;
    }

    public void setApto(String apto) {
        this.apto = apto;
    }

    public Responsavel getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Responsavel responsavel) {
        this.responsavel = responsavel;
    }
}
