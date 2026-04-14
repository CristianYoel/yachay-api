package com.cibertec.yachay.services;

import com.cibertec.yachay.entities.Pregunta;
import com.cibertec.yachay.repositories.PreguntaRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PreguntaService {

    private final PreguntaRepositorio preguntaRepositorio;

    public List<Pregunta> listar() {
        return preguntaRepositorio.findAll();
    }

    public List<Pregunta> listarPorTema(Long idTema) {
        return preguntaRepositorio.findByTemaIdTema(idTema);
    }

    public Pregunta obtener(Long id) {
        return preguntaRepositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Pregunta no encontrada con id: " + id));
    }

    public Pregunta crear(Pregunta pregunta) {
        return preguntaRepositorio.save(pregunta);
    }

    public Pregunta actualizar(Long id, Pregunta pregunta) {
        Pregunta existente = obtener(id);
        existente.setTexto(pregunta.getTexto());
        existente.setNivel(pregunta.getNivel());
        existente.setTema(pregunta.getTema());
        return preguntaRepositorio.save(existente);
    }

    public void eliminar(Long id) {
        preguntaRepositorio.deleteById(id);
    }
}