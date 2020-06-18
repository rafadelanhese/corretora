package com.delanhese.corretora.repository;

import com.delanhese.corretora.model.Segmento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * SegmentoRepository
 */
@Repository
public interface SegmentoRepository extends JpaRepository<Segmento, Long>{
    
}