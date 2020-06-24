package com.delanhese.corretora.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.delanhese.corretora.interfaces.IAtivoService;
import com.delanhese.corretora.model.Ativo;
import com.delanhese.corretora.repository.AtivoRepository;

@Service
public class AtivoServiceImpl implements IAtivoService{

	@Autowired
	private AtivoRepository ativoRepository;
	
	
	@Override
	public ResponseEntity<List<Ativo>> findAll() {
		return ResponseEntity.ok().body(ativoRepository.findAll());			
	}

	@Override
	public ResponseEntity<?> save(Ativo ativo) {
		ativoRepository.save(ativo);
		return ResponseEntity.ok().build();
	}
	
	@Override
	public ResponseEntity<Ativo> update(Long id, Ativo ativo) {
		 return ativoRepository.findById(id)
		           .map(record -> {
                       record.setNomePregao(ativo.getNomePregao());  
                       record.setTicker(ativo.getTicker());
                       record.setSegmento(ativo.getSegmento());
                       record.setSetor(ativo.getSetor());
                       record.setListaAportes(ativo.getListaAportes());
		               Ativo updated = ativoRepository.save(record);
		               return ResponseEntity.ok().body(updated);
		           }).orElse(ResponseEntity.notFound().build());
	}

	@Override
	public ResponseEntity<Ativo> findById(Long id) {
		return ativoRepository.findById(id)
			   .map(record -> ResponseEntity.ok().body(record))
			   .orElse(ResponseEntity.notFound().build());
	}


	@Override
	public ResponseEntity<?> delete(Long id) {
		return ativoRepository.findById(id)
				.map(record -> {
		        	   ativoRepository.deleteById(id);
		               return ResponseEntity.ok().build();
		           }).orElse(ResponseEntity.notFound().build());
	}

	public boolean exists(Ativo ativo) {	
		Example<Ativo> example = Example.of(ativo);
		return ativoRepository.exists(example);
	}
	
}
