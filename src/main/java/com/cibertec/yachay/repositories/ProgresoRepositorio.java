package com.cibertec.yachay.repositories;

import com.cibertec.yachay.entities.Progreso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProgresoRepositorio extends JpaRepository<Progreso, Long> {
    List<Progreso> findByEvaluacionIdEvaluacion(Long idEvaluacion);
}