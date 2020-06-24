package com.delanhese.corretora.controller;

import java.util.List;

import javax.validation.Valid;

import com.delanhese.corretora.model.Aporte;
import com.delanhese.corretora.service.AporteServiceImpl;

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
@RequestMapping(value = "/aporte")
public class AporteController {

    private AporteServiceImpl aporteService;
    private final String PATH_ID = "/{id}";

    public AporteController(AporteServiceImpl aporteService) {
        this.aporteService = aporteService;
    }

    @GetMapping    
    public ResponseEntity<List<Aporte>> findAll() {
        return aporteService.findAll();
    }
    
    @GetMapping(path = PATH_ID, produces = "application/json")
    public ResponseEntity<Aporte> findById(@PathVariable Long id) {
        return aporteService.findById(id);
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody Aporte aporte) {
        return aporteService.save(aporte);
    }   

    @PutMapping(value = PATH_ID)
    public ResponseEntity<Aporte> update(@PathVariable("id") Long id, @RequestBody Aporte aporte) {
       return aporteService.update(id, aporte);
    }

    @DeleteMapping(path = PATH_ID)
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return aporteService.delete(id);
    }

}