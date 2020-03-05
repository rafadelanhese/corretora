package com.delanhese.corretora.service;

import java.util.List;

import com.delanhese.corretora.model.Setor;

import org.springframework.http.ResponseEntity;

/**
 * SetorService
 */
public interface SetorService {
    
    ResponseEntity<List<Setor>> findAll();
    ResponseEntity<Setor> save(Setor setor);
    ResponseEntity<Setor> findById(Long id);   
    ResponseEntity<Setor> update(Long id, Setor setor);
    ResponseEntity<?> delete(Long id);        
}