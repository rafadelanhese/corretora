package com.delanhese.corretora.controller;

import java.util.List;

import javax.validation.Valid;

import com.delanhese.corretora.model.Ativo;
import com.delanhese.corretora.service.AtivoServiceImpl;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/ativo")
public class AtivoController {
    
    private AtivoServiceImpl ativoService;
    private final String PATH_ID = "/{id}";

    public AtivoController(AtivoServiceImpl ativoService) {
        this.ativoService = ativoService;
    }

    @GetMapping    
    public ResponseEntity<List<Ativo>> findAll() {
        return ativoService.findAll();
    }
    
    @GetMapping(path = PATH_ID, produces = "application/json")
    public ResponseEntity<Ativo> findById(@PathVariable Long id) {
        return ativoService.findById(id);
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody Ativo ativo) {
        return ativoService.save(ativo);
    }   

    @PutMapping(value = PATH_ID)
    public ResponseEntity<Ativo> update(@PathVariable("id") Long id, @RequestBody Ativo ativo) {
       return ativoService.update(id, ativo);
    }

    @DeleteMapping(path = PATH_ID)
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return ativoService.delete(id);
    }

}