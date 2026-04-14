package com.cibertec.yachay.controllers;

import com.cibertec.yachay.entities.OpcionRespuesta;
import com.cibertec.yachay.services.OpcionRespuestaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/opciones")
@RequiredArgsConstructor
public class OpcionRespuestaController {

    private final OpcionRespuestaService opcionRespuestaService;

    @GetMapping
    public List<OpcionRespuesta> listar() {
        return opcionRespuestaService.listar();
    }

    @GetMapping("/pregunta/{idPregunta}")
    public List<OpcionRespuesta> listarPorPregunta(@PathVariable Long idPregunta) {
        return opcionRespuestaService.listarPorPregunta(idPregunta);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OpcionRespuesta> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(opcionRespuestaService.obtener(id));
    }

    @PostMapping
    public ResponseEntity<OpcionRespuesta> crear(@RequestBody OpcionRespuesta opcion) {
        return ResponseEntity.ok(opcionRespuestaService.crear(opcion));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OpcionRespuesta> actualizar(@PathVariable Long id, @RequestBody OpcionRespuesta opcion) {
        return ResponseEntity.ok(opcionRespuestaService.actualizar(id, opcion));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        opcionRespuestaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}