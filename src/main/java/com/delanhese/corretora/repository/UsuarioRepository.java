package com.delanhese.corretora.repository;

import com.delanhese.corretora.model.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * AporteRepository
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    
}