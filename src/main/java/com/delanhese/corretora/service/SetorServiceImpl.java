package com.delanhese.corretora.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.delanhese.corretora.interfaces.ISetorService;
import com.delanhese.corretora.model.Setor;
import com.delanhese.corretora.repository.SetorRepository;

@Service
public class SetorServiceImpl implements ISetorService{

	@Autowired
	private SetorRepository setorRepository;
	
	
	@Override
	public ResponseEntity<List<Setor>> findAll() {
		return ResponseEntity.ok().body(setorRepository.findAll());			
	}

	@Override
	public ResponseEntity<?> save(Setor setor) {
		setorRepository.save(setor);
		return ResponseEntity.ok().build();
	}
	
	@Override
	public ResponseEntity<Setor> update(Long id, Setor setor) {
		 return setorRepository.findById(id)
		           .map(record -> {
		               record.setNome(setor.getNome());		               
		               Setor updated = setorRepository.save(record);
		               return ResponseEntity.ok().body(updated);
		           }).orElse(ResponseEntity.notFound().build());
	}

	@Override
	public ResponseEntity<Setor> findById(Long id) {
		return setorRepository.findById(id)
			   .map(record -> ResponseEntity.ok().body(record))
			   .orElse(ResponseEntity.notFound().build());
	}


	@Override
	public ResponseEntity<?> delete(Long id) {
		return setorRepository.findById(id)
				.map(record -> {
		        	   setorRepository.deleteById(id);
		               return ResponseEntity.ok().build();
		           }).orElse(ResponseEntity.notFound().build());
	}

	public boolean exists(Setor setor) {	
		Example<Setor> example = Example.of(setor);
		return setorRepository.exists(example);
	}
	
}
