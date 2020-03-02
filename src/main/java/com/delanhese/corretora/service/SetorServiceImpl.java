package com.delanhese.corretora.service;

import java.util.List;

import com.delanhese.corretora.model.Setor;
import com.delanhese.corretora.repository.SetorRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

/**
 * SetorService
 */
@Service
@AllArgsConstructor
public class SetorServiceImpl implements SetorService{

    private final SetorRepository repository;  

    @Override
    public Setor save(Setor setor) {
        return repository.save(setor);
    }

    @Override
    public List<Setor> findAll() {
        return repository.findAll();
    }

    @Override
    public ResponseEntity<?> update(Long id, Setor setor) {
        return repository.findById(id).map(record -> {
            record.setNome(setor.getNome());
            Setor setorUpdated = repository.save(record);
            return ResponseEntity.ok().body(setorUpdated);
        }).orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        return repository.findById(id)
                .map(record -> {
                    repository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
     }

    @Override
    public ResponseEntity<?> findById(Long id) {
        return repository.findById(id).map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }
}