package com.delanhese.corretora.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Setor
 * AllArgsConstructor: cria automaticamente um construtor com todas os atributos da classe como argumento.
 * NoArgsConstructor: cria automaticamente um construtor vazio (sem argumentos).
 * Data: cria automaticamente os métodos toString, equals, hashCode, getters e setters.
 */
@Entity
public class Setor implements Serializable{

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idSetor;

    @NotNull
    @NotEmpty
    private String nome;

    
    public Setor() {
    	
    }
    
    
    public Setor(Long idSetor, @NotNull @NotEmpty String nome) {
		super();
		this.idSetor = idSetor;
		this.nome = nome;
	}

	
	public Long getIdSetor() {
		return idSetor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
    
}