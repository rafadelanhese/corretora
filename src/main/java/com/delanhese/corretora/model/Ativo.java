package com.delanhese.corretora.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public abstract class Ativo implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter private Long idSetor;

    @NotNull
    @NotEmpty
    private String nomePregao;

    @NotNull
    @NotEmpty
    private String ticker;

    @NotNull
    @NotEmpty
    private Segmento segmento;

    
}