package com.cibertec.yachay.controllers;

import com.cibertec.yachay.entities.Progreso;
import com.cibertec.yachay.services.ProgresoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/progresos")
@RequiredArgsConstructor
public class ProgresoController {

    private final ProgresoService progresoService;

    @GetMapping("/usuario/{idUsuario}")
    public List<Progreso> progresoUsuario(
            @PathVariable Long idUsuario){

        return progresoService
                .listarPorUsuario(idUsuario);

    }


    @GetMapping
    public List<Progreso> listar() {
        return progresoService.listar();
    }

    @GetMapping("/evaluacion/{idEvaluacion}")
    public List<Progreso> listarPorEvaluacion(@PathVariable Long idEvaluacion) {
        return progresoService.listarPorEvaluacion(idEvaluacion);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Progreso> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(progresoService.obtener(id));
    }

    @PostMapping
    public ResponseEntity<Progreso> crear(@RequestBody Progreso progreso) {
        return ResponseEntity.ok(progresoService.crear(progreso));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Progreso> actualizar(@PathVariable Long id, @RequestBody Progreso progreso) {
        return ResponseEntity.ok(progresoService.actualizar(id, progreso));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        progresoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}