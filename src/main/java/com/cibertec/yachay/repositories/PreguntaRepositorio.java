package com.cibertec.yachay.repositories;

import com.cibertec.yachay.entities.Pregunta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PreguntaRepositorio extends JpaRepository<Pregunta, Long> {
    List<Pregunta> findByTemaIdTema(Long idTema);
}