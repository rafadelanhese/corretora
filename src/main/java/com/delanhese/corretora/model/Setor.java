package com.delanhese.corretora.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Setor
 * AllArgsConstructor: cria automaticamente um construtor com todas os atributos da classe como argumento.
 * NoArgsConstructor: cria automaticamente um construtor vazio (sem argumentos).
 * Data: cria automaticamente os métodos toString, equals, hashCode, getters e setters.
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Setor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSetor;
    private String nome;   
    
}