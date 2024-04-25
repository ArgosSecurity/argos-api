package com.argos.argos.model.entities;

import jakarta.persistence.*;

@Entity
public class Administrador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @ManyToOne
    @JoinColumn(name = "idLoginAcesso", referencedColumnName = "id")
    private LoginAcesso loginAcesso;

    public Administrador(){}

    public Administrador(String nome, LoginAcesso loginAcesso) {
        this.nome = nome;
        this.loginAcesso = loginAcesso;
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
}
