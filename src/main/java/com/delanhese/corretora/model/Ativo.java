package com.delanhese.corretora.model;

import java.io.Serializable;
import java.util.List;

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
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public abstract class Ativo implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter private Long idAtivo;

    @NotNull(message = "{nomePregao.not.null}")
    @NotEmpty(message = "{nomePregao.not.empty}")
    @Getter @Setter private String nomePregao;

    @NotNull(message = "{ticker.not.null}")
    @NotEmpty(message = "{ticker.not.empty}")
    @Size(min=4,max=4, message="{ticker.size}")
    @Getter @Setter private String ticker;

    @NotNull(message = "{segmento.not.null}")
    @NotEmpty(message = "{segmento.not.empty}")
    @Getter @Setter private Segmento segmento;

    @NotNull(message = "{setor.not.null}")
    @NotEmpty(message = "{setor.not.empty}")
    @Getter @Setter private Setor setor;
    
    @Getter @Setter private List<Aporte> listaAportes;
}