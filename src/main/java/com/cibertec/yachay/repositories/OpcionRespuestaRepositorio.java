package com.cibertec.yachay.repositories;

import com.cibertec.yachay.entities.OpcionRespuesta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface OpcionRespuestaRepositorio extends JpaRepository<OpcionRespuesta, Long> {

    List<OpcionRespuesta> findByPreguntaIdPregunta(
            Long idPregunta
    );

    long countByPreguntaIdPregunta(
            Long idPregunta
    );

}