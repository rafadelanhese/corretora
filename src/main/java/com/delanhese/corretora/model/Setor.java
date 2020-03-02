package com.delanhese.corretora.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Setor
 */
@Entity
public class Setor {

    @Id
    @GeneratedValue
    private long idSetor;
    private String nome;


    public Setor() {
    }

    public Setor(String nome) {       
        this.nome = nome;
    }

    public Setor(long idSetor, String nome) {
        this.idSetor = idSetor;
        this.nome = nome;
    }

    public long getIdSetor() {
        return this.idSetor;
    }

    public void setIdSetor(long idSetor) {
        this.idSetor = idSetor;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Setor idSetor(long idSetor) {
        this.idSetor = idSetor;
        return this;
    }

    public Setor nome(String nome) {
        this.nome = nome;
        return this;
    }
}