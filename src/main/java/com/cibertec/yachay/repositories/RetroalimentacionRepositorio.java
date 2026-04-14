package com.cibertec.yachay.repositories;

import com.cibertec.yachay.entities.Retroalimentacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RetroalimentacionRepositorio extends JpaRepository<Retroalimentacion, Long> {
    List<Retroalimentacion> findByTemaIdTema(Long idTema);
}