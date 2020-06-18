package com.delanhese.corretora.repository;
import com.delanhese.corretora.model.Aporte;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * AporteRepository
 */
@Repository
public interface AporteRepository extends JpaRepository<Aporte, Long>{
    
}