package com.argos.argos.model.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Entity
public class Responsavel {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   private String nome;
   private LocalDate dataNascimento;
   private String rg;
   private String apto;

   @OneToOne
   @JoinColumn(name = "idLoginAcesso", referencedColumnName = "id")
   private LoginAcesso loginAcesso;

   public Responsavel(){}

   public Responsavel(String nome, String dataNascimento, String rg, String apto, LoginAcesso loginAcesso) {
      this.nome = nome;
      this.dataNascimento = LocalDate.parse(dataNascimento, DateTimeFormatter.ofPattern("uuuu-MM-dd"));;
      this.rg = rg;
      this.apto = apto;
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

   public LocalDate getDataNascimento() {
      return dataNascimento;
   }

   public void setDataNascimento(String dataNascimento) {
      this.dataNascimento = LocalDate.parse(dataNascimento, DateTimeFormatter.ofPattern("uuuu-MM-dd"));;
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

   public LoginAcesso getLoginAcesso() {
      return loginAcesso;
   }

   public void setLoginAcesso(LoginAcesso loginAcesso) {
      this.loginAcesso = loginAcesso;
   }
}
