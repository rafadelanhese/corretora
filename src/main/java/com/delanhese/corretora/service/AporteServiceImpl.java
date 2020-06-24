package com.delanhese.corretora.service;

import java.util.List;

import com.delanhese.corretora.interfaces.IAporteService;
import com.delanhese.corretora.model.Aporte;
import com.delanhese.corretora.repository.AporteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AporteServiceImpl implements IAporteService {

    @Autowired
    private AporteRepository aporteRepository;

    @Override
	public ResponseEntity<List<Aporte>> findAll() {
		return ResponseEntity.ok().body(aporteRepository.findAll());			
	}

	@Override
	public ResponseEntity<?> save(Aporte aporte) {
		aporteRepository.save(aporte);
		return ResponseEntity.ok().build();
	}
	
	@Override
	public ResponseEntity<Aporte> update(Long id, Aporte aporte) {
		 return aporteRepository.findById(id)
		           .map(record -> {
                       record.setAtivo(aporte.getAtivo());
                       record.setPreco(aporte.getPreco());
                       record.setQuantidade(aporte.getQuantidade());
                       record.setUsuario(aporte.getUsuario());               
		               Aporte updated = aporteRepository.save(record);
		               return ResponseEntity.ok().body(updated);
		           }).orElse(ResponseEntity.notFound().build());
	}

	@Override
	public ResponseEntity<Aporte> findById(Long id) {
		return aporteRepository.findById(id)
			   .map(record -> ResponseEntity.ok().body(record))
			   .orElse(ResponseEntity.notFound().build());
	}


	@Override
	public ResponseEntity<?> delete(Long id) {
		return aporteRepository.findById(id)
				.map(record -> {
		        	   aporteRepository.deleteById(id);
		               return ResponseEntity.ok().build();
		           }).orElse(ResponseEntity.notFound().build());
	}

	public boolean exists(Aporte aporte) {	
		Example<Aporte> example = Example.of(aporte);
		return aporteRepository.exists(example);
	}
	
    
}