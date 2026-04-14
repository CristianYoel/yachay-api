package com.cibertec.yachay.services;

import com.cibertec.yachay.entities.RespuestaUsuario;
import com.cibertec.yachay.repositories.RespuestaUsuarioRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RespuestaUsuarioService {

    private final RespuestaUsuarioRepositorio respuestaUsuarioRepositorio;

    public List<RespuestaUsuario> listar() {
        return respuestaUsuarioRepositorio.findAll();
    }

    public List<RespuestaUsuario> listarPorEvaluacion(Long idEvaluacion) {
        return respuestaUsuarioRepositorio.findByEvaluacionIdEvaluacion(idEvaluacion);
    }

    public RespuestaUsuario obtener(Long id) {
        return respuestaUsuarioRepositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Respuesta no encontrada con id: " + id));
    }

    public RespuestaUsuario crear(RespuestaUsuario respuesta) {
        return respuestaUsuarioRepositorio.save(respuesta);
    }

    public RespuestaUsuario actualizar(Long id, RespuestaUsuario respuesta) {
        RespuestaUsuario existente = obtener(id);
        existente.setPesoObtenido(respuesta.getPesoObtenido());
        existente.setEvaluacion(respuesta.getEvaluacion());
        existente.setPregunta(respuesta.getPregunta());
        existente.setOpcionRespuesta(respuesta.getOpcionRespuesta());
        return respuestaUsuarioRepositorio.save(existente);
    }

    public void eliminar(Long id) {
        respuestaUsuarioRepositorio.deleteById(id);
    }
}