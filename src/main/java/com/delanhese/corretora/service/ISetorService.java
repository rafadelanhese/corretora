package com.delanhese.corretora.service;

import java.util.List;
import java.util.Optional;

import com.delanhese.corretora.model.Setor;

import org.springframework.http.ResponseEntity;

/**
 * SetorService
 */
public interface ISetorService {

	ResponseEntity<List<Setor>> findAll();
	ResponseEntity<?> save(Setor setor);
	ResponseEntity<Setor> update(Long id, Setor setor);
	ResponseEntity<Setor> findById(Long id);   
	ResponseEntity<?> delete(Long id);        
}