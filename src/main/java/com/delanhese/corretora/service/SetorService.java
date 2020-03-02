package com.delanhese.corretora.service;

import java.util.List;

import com.delanhese.corretora.model.Setor;
import com.delanhese.corretora.repository.SetorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * SetorService
 */
@Service
public class SetorService {

    private SetorRepository repository;

    @Autowired
    public SetorService(SetorRepository repository) {
        this.repository = repository;
    }

    public Setor save(Setor setor) {
        return repository.save(setor);
    }

    public List<Setor> findAll() {
        return repository.findAll();
    }

    public ResponseEntity<?> update(Long id, Setor setor) {
        return repository.findById(id).map(record -> {
            record.setNome(setor.getNome());
            Setor setorUpdated = repository.save(record);
            return ResponseEntity.ok().body(setorUpdated);
        }).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<?> delete(Long id) {
        return repository.findById(id)
                .map(record -> {
                    repository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
     }

    public ResponseEntity<?> findById(Long id) {
        return repository.findById(id).map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }
}