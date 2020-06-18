package com.delanhese.corretora.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Aporte implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter private Long idAporte;


    @NotNull(message = "{ativo.not.null}")
    @NotEmpty(message = "{ativo.not.empty}")
    @Getter @Setter private Ativo ativo;

    @NotNull(message = "{usuario.not.null}")
    @NotEmpty(message = "{usuario.not.empty}")
    @Getter @Setter private Usuario usuario;

    @Getter @Setter private BigDecimal preco;

    @Getter @Setter private int quantidade;
}