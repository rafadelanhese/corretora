package com.delanhese.corretora.repository;

import com.delanhese.corretora.model.Setor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * SetorRepository
 */
@Repository
public interface SetorRepository extends JpaRepository<Setor, Long>{
    
}