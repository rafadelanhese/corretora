package com.delanhese.corretora.controller;

import java.util.List;

import com.delanhese.corretora.model.Setor;
import com.delanhese.corretora.service.SetorService;

import org.springframework.beans.factory.annotation.Autowired;
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

    private SetorService setorService;
    
    @Autowired
    public SetorController(SetorService setorService){
        this.setorService = setorService;
    }

    @PostMapping
    public Setor create(@RequestBody Setor setor) {
        return setorService.save(setor);
    }

    @GetMapping
    public List<Setor> setores() {
        return setorService.findAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return setorService.findById(id);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody Setor setor) {
        return setorService.update(id, setor);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return setorService.delete(id);
    }
}