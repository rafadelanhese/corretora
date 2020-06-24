package com.delanhese.corretora.interfaces;

import java.util.List;

import com.delanhese.corretora.model.Aporte;

import org.springframework.http.ResponseEntity;

public interface IAporteService {
    ResponseEntity<List<Aporte>> findAll();
	ResponseEntity<?> save(Aporte aporte);
	ResponseEntity<Aporte> update(Long id, Aporte aporte);
	ResponseEntity<Aporte> findById(Long id);   
	ResponseEntity<?> delete(Long id);        
}