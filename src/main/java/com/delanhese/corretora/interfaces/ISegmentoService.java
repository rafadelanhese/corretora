package com.delanhese.corretora.interfaces;

import java.util.List;

import com.delanhese.corretora.model.Segmento;

import org.springframework.http.ResponseEntity;

public interface ISegmentoService {
    
    ResponseEntity<List<Segmento>> findAll();
	ResponseEntity<?> save(Segmento segmento);
	ResponseEntity<Segmento> update(Long id, Segmento segmento);
	ResponseEntity<Segmento> findById(Long id);   
	ResponseEntity<?> delete(Long id);        
}