package com.cibertec.yachay.services;

import com.cibertec.yachay.entities.Evaluacion;
import com.cibertec.yachay.repositories.EvaluacionRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EvaluacionService {

    private final EvaluacionRepositorio evaluacionRepositorio;

    public List<Evaluacion> listar() {
        return evaluacionRepositorio.findAll();
    }

    public List<Evaluacion> listarPorUsuario(Long idUsuario) {
        return evaluacionRepositorio.findByUsuarioIdUsuario(idUsuario);
    }

    public Evaluacion obtener(Long id) {
        return evaluacionRepositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Evaluacion no encontrada con id: " + id));
    }

    public Evaluacion crear(Evaluacion evaluacion) {
        Evaluacion guardada = evaluacionRepositorio.save(evaluacion);
        return evaluacionRepositorio.findById(guardada.getIdEvaluacion())
                .orElseThrow();
    }

    public Evaluacion actualizar(Long id, Evaluacion evaluacion) {
        Evaluacion existente = obtener(id);
        existente.setFechaInicio(evaluacion.getFechaInicio());
        existente.setEstado(evaluacion.getEstado());
        existente.setUsuario(evaluacion.getUsuario());
        existente.setTema(evaluacion.getTema());
        return evaluacionRepositorio.save(existente);
    }

    public void eliminar(Long id) {
        evaluacionRepositorio.deleteById(id);
    }
}