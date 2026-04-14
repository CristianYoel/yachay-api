package com.cibertec.yachay.repositories;

import com.cibertec.yachay.entities.RespuestaUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RespuestaUsuarioRepositorio extends JpaRepository<RespuestaUsuario, Long> {
    List<RespuestaUsuario> findByEvaluacionIdEvaluacion(Long idEvaluacion);
}