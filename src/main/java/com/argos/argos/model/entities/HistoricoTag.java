package com.argos.argos.model.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class HistoricoTag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private final LocalDateTime timestamp = LocalDateTime.now();

    private Long tagID;
    private String responsavel;
    private String rgResponsavel;
    private String typeAtividade;

    public HistoricoTag() {
    }

    public HistoricoTag(Long tagID, String responsavel, String rgResponsavel, String typeAtividade) {
        this.tagID = tagID;
        this.responsavel = responsavel;
        this.rgResponsavel = rgResponsavel;
        this.typeAtividade = typeAtividade;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public Long getTag() {
        return tagID;
    }

    public void setTag(Long tagID) {
        this.tagID = tagID;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public String getRgResponsavel() {
        return rgResponsavel;
    }

    public void setRgResponsavel(String rgResponsavel) {
        this.rgResponsavel = rgResponsavel;
    }

    public String getTypeAtividade() {
        return typeAtividade;
    }

    public void setTypeAtividade(String typeAtividade) {
        this.typeAtividade = typeAtividade;
    }
}