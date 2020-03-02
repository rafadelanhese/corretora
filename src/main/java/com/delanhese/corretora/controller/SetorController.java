package com.delanhese.corretora.controller;

import java.util.List;

import com.delanhese.corretora.model.Setor;
import com.delanhese.corretora.service.SetorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * SetorController
 */
@RestController
@RequestMapping(value = "/setor")
public class SetorController {

    
    @Autowired
    private SetorService setorService;

    @GetMapping
    public List<Setor> setores(){
        return setorService.findAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Setor> findById(@PathVariable Long id){
        return setorService.findById(id);
    }

    @PostMapping
    public void salvarSetor(@RequestBody Setor setor) {               
        setorService.save(setor);
    }
}