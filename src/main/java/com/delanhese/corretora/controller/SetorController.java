package com.delanhese.corretora.controller;

import java.util.List;

import javax.validation.Valid;

import com.delanhese.corretora.model.Setor;
import com.delanhese.corretora.service.SetorServiceImpl;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * SetorController
 */
@RestController
@RequestMapping(value = "/setor")
public class SetorController {

    private SetorServiceImpl setorService;
    private final String PATH_ID = "/{id}";

    public SetorController(SetorServiceImpl setorService) {
        this.setorService = setorService;
    }

    @GetMapping    
    public ResponseEntity<List<Setor>> findAll() {
        return setorService.findAll();
    }
    
    @GetMapping(path = PATH_ID, produces = "application/json")
    public ResponseEntity<Setor> findById(@PathVariable Long id) {
        return setorService.findById(id);
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody Setor setor) {
        return setorService.save(setor);
    }   

    @PutMapping(value = PATH_ID)
    public ResponseEntity<Setor> update(@PathVariable("id") Long id, @RequestBody Setor setor) {
       return setorService.update(id, setor);
    }

    @DeleteMapping(path = PATH_ID)
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return setorService.delete(id);
    }

}