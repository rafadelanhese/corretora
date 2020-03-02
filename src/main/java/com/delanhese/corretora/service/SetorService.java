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

    @Autowired
    private SetorRepository setorRepository;

    public List<Setor> findAll(){
        return setorRepository.findAll();
    }

    public ResponseEntity<Setor> findById(Long id){
        return setorRepository.findById(id)
        .map(record -> ResponseEntity.ok().body(record))
        .orElse(ResponseEntity.notFound().build());
    }

    public void save(Setor setor){
        setorRepository.save(setor);
    }
}