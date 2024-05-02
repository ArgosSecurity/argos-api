package com.argos.argos.model.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Responsavel {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   private String nome;
   private Date dataNascimento;
   private String rg;
   private String apto;

   @OneToOne
   @JoinColumn(name = "idLoginAcesso", referencedColumnName = "id")
   private LoginAcesso loginAcesso;

   public Responsavel(){}

   public Responsavel(String nome, Date dataNascimento, String rg, String apto, LoginAcesso loginAcesso) {
      this.nome = nome;
      this.dataNascimento = dataNascimento;
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

   public Date getDataNascimento() {
      return dataNascimento;
   }

   public void setDataNascimento(Date dataNascimento) {
      this.dataNascimento = dataNascimento;
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
