package com.delanhese.corretora.service;

import java.util.List;

import com.delanhese.corretora.model.Setor;
import com.delanhese.corretora.repository.SetorRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * SetorService
 */
@Service
public class SetorServiceImpl implements SetorService {

    private final SetorRepository repository;

    public SetorServiceImpl(SetorRepository repository) {
        this.repository = repository;
    }

    @Override
    public ResponseEntity<Setor> findById(Long id) {
        return repository.findById(id).map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<Setor> save(Setor setor) {
        try {
            repository.save(setor);
            return ResponseEntity.ok().body(setor);
        } catch (Exception e) {
            System.out.println("Erro ao salvar: " + e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<List<Setor>> findAll() {
        return ResponseEntity.ok().body(repository.findAll());
    }

    @Override
    public ResponseEntity<Setor> update(Long id, Setor setor) {
        return repository.findById(id).map(record -> {
            record.setNome(setor.getNome());
            Setor setorUpdated = repository.save(record);
            return ResponseEntity.ok().body(setorUpdated);
        }).orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        return repository.findById(id).map(record -> {
            repository.deleteById(id);
            return ResponseEntity.ok().build();
        }).orElse(ResponseEntity.notFound().build());
    }
}