package com.delanhese.corretora.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Setor
 * AllArgsConstructor: cria automaticamente um construtor com todas os atributos da classe como argumento.
 * NoArgsConstructor: cria automaticamente um construtor vazio (sem argumentos).
 * Data: cria automaticamente os métodos toString, equals, hashCode, getters e setters.
 */
//@AllArgsConstructor
//@NoArgsConstructor
//@Data
@Entity
public class Setor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSetor;
    private String nome; 
    

    public Setor() {
    }


    public Setor(Long idSetor, String nome) {
        this.idSetor = idSetor;
        this.nome = nome;
    }

    public Long getIdSetor() {
        return this.idSetor;
    }

    public void setIdSetor(Long idSetor) {
        this.idSetor = idSetor;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Setor idSetor(Long idSetor) {
        this.idSetor = idSetor;
        return this;
    }

    public Setor nome(String nome) {
        this.nome = nome;
        return this;
    }
    
    @Override
    public String toString() {
        return "{" +
            " idSetor='" + getIdSetor() + "'" +
            ", nome='" + getNome() + "'" +
            "}";
    }

    
}