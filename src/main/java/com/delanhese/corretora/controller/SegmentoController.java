package com.delanhese.corretora.controller;

import java.util.List;

import javax.validation.Valid;

import com.delanhese.corretora.model.Segmento;
import com.delanhese.corretora.service.SegmentoServiceImpl;

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
@RequestMapping(value = "/segmento")
public class SegmentoController {
    
    private SegmentoServiceImpl segmentoService;
    private final String PATH_ID = "/{id}";

    public SegmentoController(SegmentoServiceImpl segmentoService) {
        this.segmentoService = segmentoService;
    }

    @GetMapping    
    public ResponseEntity<List<Segmento>> findAll() {
        return segmentoService.findAll();
    }
    
    @GetMapping(path = PATH_ID, produces = "application/json")
    public ResponseEntity<Segmento> findById(@PathVariable Long id) {
        return segmentoService.findById(id);
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody Segmento setor) {
        return segmentoService.save(setor);
    }   

    @PutMapping(value = PATH_ID)
    public ResponseEntity<Segmento> update(@PathVariable("id") Long id, @RequestBody Segmento setor) {
       return segmentoService.update(id, setor);
    }

    @DeleteMapping(path = PATH_ID)
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return segmentoService.delete(id);
    }

}