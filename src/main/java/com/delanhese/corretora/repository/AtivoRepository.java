package com.delanhese.corretora.repository;
import com.delanhese.corretora.model.Ativo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * AtivoRepository
 */
@Repository
public interface AtivoRepository extends JpaRepository<Ativo, Long>{
    
}