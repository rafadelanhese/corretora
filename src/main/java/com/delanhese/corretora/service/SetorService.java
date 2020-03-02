package com.delanhese.corretora.service;

import java.util.List;

import com.delanhese.corretora.model.Setor;

import org.springframework.http.ResponseEntity;

/**
 * SetorService
 */
public interface SetorService {
    
    List<Setor> findAll();
    Setor save(Setor setor);
    ResponseEntity<?> findById(Long id);
    ResponseEntity<?> update(Long id, Setor setor);
    ResponseEntity<?> delete(Long id);    
    
}