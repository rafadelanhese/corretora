package com.delanhese.corretora.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.delanhese.corretora.interfaces.ISegmentoService;
import com.delanhese.corretora.model.Segmento;
import com.delanhese.corretora.repository.SegmentoRepository;

@Service
public class SegmentoServiceImpl implements ISegmentoService{

	@Autowired
	private SegmentoRepository segmentoRepository;
	
	
	@Override
	public ResponseEntity<List<Segmento>> findAll() {
		return ResponseEntity.ok().body(segmentoRepository.findAll());			
	}

	@Override
	public ResponseEntity<?> save(Segmento segmento) {
		segmentoRepository.save(segmento);
		return ResponseEntity.ok().build();
	}
	
	@Override
	public ResponseEntity<Segmento> update(Long id, Segmento segmento) {
		 return segmentoRepository.findById(id)
		           .map(record -> {
		               record.setNome(segmento.getNome());		               
		               Segmento updated = segmentoRepository.save(record);
		               return ResponseEntity.ok().body(updated);
		           }).orElse(ResponseEntity.notFound().build());
	}

	@Override
	public ResponseEntity<Segmento> findById(Long id) {
		return segmentoRepository.findById(id)
			   .map(record -> ResponseEntity.ok().body(record))
			   .orElse(ResponseEntity.notFound().build());
	}


	@Override
	public ResponseEntity<?> delete(Long id) {
		return segmentoRepository.findById(id)
				.map(record -> {
		        	   segmentoRepository.deleteById(id);
		               return ResponseEntity.ok().build();
		           }).orElse(ResponseEntity.notFound().build());
	}

	public boolean exists(Segmento segmento) {	
		Example<Segmento> example = Example.of(segmento);
		return segmentoRepository.exists(example);
	}
	
}
