package com.cibertec.yachay.repositories;

import com.cibertec.yachay.entities.Evaluacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EvaluacionRepositorio extends JpaRepository<Evaluacion, Long> {
    List<Evaluacion> findByUsuarioIdUsuario(Long idUsuario);
}