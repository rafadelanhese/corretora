package com.delanhese.corretora.interfaces;

import java.util.List;

import com.delanhese.corretora.model.Ativo;

import org.springframework.http.ResponseEntity;

public interface IAtivoService {
    ResponseEntity<List<Ativo>> findAll();
	ResponseEntity<?> save(Ativo aporte);
	ResponseEntity<Ativo> update(Long id, Ativo aporte);
	ResponseEntity<Ativo> findById(Long id);   
	ResponseEntity<?> delete(Long id);        
}