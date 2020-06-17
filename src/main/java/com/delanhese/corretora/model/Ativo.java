package com.delanhese.corretora.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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

    @NotNull(message = "{nomePregao.not.null}")
    @NotEmpty(message = "{nomePregao.not.empty}")
    private String nomePregao;

    @NotNull(message = "{ticker.not.null}")
    @NotEmpty(message = "{ticker.not.empty}")
    @Size(min=4,max=4, message="{ticker.size}")
    private String ticker;

    @NotNull(message = "{segmento.not.null}")
    @NotEmpty(message = "{segmento.not.empty}")
    private Segmento segmento;
    
}