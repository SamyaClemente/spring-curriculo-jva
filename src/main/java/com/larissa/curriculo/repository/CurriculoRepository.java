package com.larissa.curriculo.repository;

import com.larissa.curriculo.model.Curriculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurriculoRepository extends JpaRepository<Curriculo, Long> {
    
}