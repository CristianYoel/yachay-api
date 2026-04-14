package com.cibertec.yachay.services;

import com.cibertec.yachay.entities.Retroalimentacion;
import com.cibertec.yachay.repositories.RetroalimentacionRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RetroalimentacionService {

    private final RetroalimentacionRepositorio retroalimentacionRepositorio;

    public List<Retroalimentacion> listar() {
        return retroalimentacionRepositorio.findAll();
    }

    public List<Retroalimentacion> listarPorTema(Long idTema) {
        return retroalimentacionRepositorio.findByTemaIdTema(idTema);
    }

    public Retroalimentacion obtener(Long id) {
        return retroalimentacionRepositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Retroalimentacion no encontrada con id: " + id));
    }

    public Retroalimentacion crear(Retroalimentacion retro) {
        return retroalimentacionRepositorio.save(retro);
    }

    public Retroalimentacion actualizar(Long id, Retroalimentacion retro) {
        Retroalimentacion existente = obtener(id);
        existente.setPuntajeMin(retro.getPuntajeMin());
        existente.setPuntajeMax(retro.getPuntajeMax());
        existente.setMensaje(retro.getMensaje());
        existente.setTema(retro.getTema());
        return retroalimentacionRepositorio.save(existente);
    }

    public void eliminar(Long id) {
        retroalimentacionRepositorio.deleteById(id);
    }
}