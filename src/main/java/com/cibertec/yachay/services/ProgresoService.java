package com.cibertec.yachay.services;

import com.cibertec.yachay.entities.Progreso;
import com.cibertec.yachay.repositories.ProgresoRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProgresoService {

    private final ProgresoRepositorio progresoRepositorio;

    public List<Progreso> listar() {
        return progresoRepositorio.findAll();
    }

    public List<Progreso> listarPorEvaluacion(Long idEvaluacion) {
        return progresoRepositorio.findByEvaluacionIdEvaluacion(idEvaluacion);
    }

    public List<Progreso> listarPorUsuario(Long idUsuario) {
        return progresoRepositorio.findByEvaluacionUsuarioIdUsuario(idUsuario);
    }

    public Progreso obtener(Long id) {
        return progresoRepositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Progreso no encontrado con id: " + id));
    }

    public Progreso crear(Progreso progreso) {
        return progresoRepositorio.save(progreso);
    }

    public Progreso actualizar(Long id, Progreso progreso) {
        Progreso existente = obtener(id);
        existente.setPuntajeAcumulado(progreso.getPuntajeAcumulado());
        existente.setPreguntaActual(progreso.getPreguntaActual());
        existente.setEvaluacion(progreso.getEvaluacion());
        return progresoRepositorio.save(existente);
    }

    public void eliminar(Long id) {
        progresoRepositorio.deleteById(id);
    }
}