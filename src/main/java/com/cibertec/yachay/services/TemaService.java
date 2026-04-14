package com.cibertec.yachay.services;

import com.cibertec.yachay.entities.Tema;
import com.cibertec.yachay.repositories.TemaRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TemaService {

    private final TemaRepositorio temaRepositorio;

    public List<Tema> listar() {
        return temaRepositorio.findAll();
    }

    public Tema obtener(Long id) {
        return temaRepositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Tema no encontrado con id: " + id));
    }

    public Tema crear(Tema tema) {
        return temaRepositorio.save(tema);
    }

    public Tema actualizar(Long id, Tema tema) {
        Tema existente = obtener(id);
        existente.setNombre(tema.getNombre());
        existente.setDescripcion(tema.getDescripcion());
        return temaRepositorio.save(existente);
    }

    public void eliminar(Long id) {
        temaRepositorio.deleteById(id);
    }
}