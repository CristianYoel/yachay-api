package com.cibertec.yachay.controllers;

import com.cibertec.yachay.entities.Evaluacion;
import com.cibertec.yachay.services.EvaluacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/evaluaciones")
@RequiredArgsConstructor
public class EvaluacionController {

    private final EvaluacionService evaluacionService;

    @GetMapping
    public List<Evaluacion> listar() {
        return evaluacionService.listar();
    }

    @GetMapping("/usuario/{idUsuario}")
    public List<Evaluacion> listarPorUsuario(@PathVariable Long idUsuario) {
        return evaluacionService.listarPorUsuario(idUsuario);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Evaluacion> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(evaluacionService.obtener(id));
    }

    @PostMapping
    public ResponseEntity<Evaluacion> crear(@RequestBody Evaluacion evaluacion) {
        return ResponseEntity.ok(evaluacionService.crear(evaluacion));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Evaluacion> actualizar(@PathVariable Long id, @RequestBody Evaluacion evaluacion) {
        return ResponseEntity.ok(evaluacionService.actualizar(id, evaluacion));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        evaluacionService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}