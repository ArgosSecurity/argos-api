package com.argos.argos.model.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

enum TipoChamado {
    TAG,
    DEPENDENTE
}

@Entity
public class Chamado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TipoChamado tipoChamado;

    private String dependenteRg;

    private boolean isTagTemporaria;

    private LocalDate horarioInicioTag;

    private LocalDate horarioFimTag;

    @ManyToOne
    @JoinColumn(name = "idResponsavel", referencedColumnName = "id")
    private Responsavel responsavel;

    @ManyToOne
    @JoinColumn(name = "idAdministrador", referencedColumnName = "id")
    private Administrador administrador;

    public Chamado(){}

    public Chamado(TipoChamado tipoChamado, String dependenteRg, boolean isTagTemporaria, String horarioInicioTag, String horarioFimTag, Responsavel responsavel, Administrador administrador) {
        this.tipoChamado = tipoChamado;
        this.dependenteRg = dependenteRg;
        this.isTagTemporaria = isTagTemporaria;
        this.horarioInicioTag = LocalDate.parse(horarioInicioTag, DateTimeFormatter.ofPattern("uuuu-MM-dd"));
        this.horarioFimTag = LocalDate.parse(horarioFimTag, DateTimeFormatter.ofPattern("uuuu-MM-dd"));
        this.responsavel = responsavel;
        this.administrador = administrador;
    }

    public Long getId() {
        return id;
    }

    public TipoChamado getTipoChamado() {
        return tipoChamado;
    }

    public void setTipoChamado(TipoChamado tipoChamado) {
        this.tipoChamado = tipoChamado;
    }

    public String getDependenteRg() {
        return dependenteRg;
    }

    public void setDependenteRg(String dependenteRg) {
        this.dependenteRg = dependenteRg;
    }

    public boolean getIsTagTemporaria() {
        return isTagTemporaria;
    }

    public void setIsTagTemporaria(boolean isTagTemporaria) {
        this.isTagTemporaria = isTagTemporaria;
    }

    public LocalDate getHorarioInicioTag() {
        return horarioInicioTag;
    }

    public void setHorarioInicioTag(String horarioInicioTag) {
        this.horarioInicioTag = LocalDate.parse(horarioInicioTag, DateTimeFormatter.ofPattern("uuuu-MM-dd"));
    }

    public LocalDate getHorarioFimTag() {
        return horarioFimTag;
    }

    public void setHorarioFimTag(String horarioFimTag) {
        this.horarioFimTag = LocalDate.parse(horarioFimTag, DateTimeFormatter.ofPattern("uuuu-MM-dd"));
    }

    public Responsavel getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Responsavel responsavel) {
        this.responsavel = responsavel;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }
}
