package com.cibertec.yachay.controllers;

import com.cibertec.yachay.entities.Pregunta;
import com.cibertec.yachay.services.PreguntaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/preguntas")
@RequiredArgsConstructor
@CrossOrigin(origins="http://localhost:4200")
public class PreguntaController {

    private final PreguntaService preguntaService;

    @GetMapping
    public List<Pregunta> listar() {
        return preguntaService.listar();
    }

    @GetMapping("/tema/{idTema}")
    public List<Pregunta> listarPorTema(@PathVariable Long idTema) {
        return preguntaService.listarPorTema(idTema);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pregunta> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(preguntaService.obtener(id));
    }

    @PostMapping
    public ResponseEntity<Pregunta> crear(@RequestBody Pregunta pregunta) {
        return ResponseEntity.ok(preguntaService.crear(pregunta));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pregunta> actualizar(@PathVariable Long id, @RequestBody Pregunta pregunta) {
        return ResponseEntity.ok(preguntaService.actualizar(id, pregunta));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        preguntaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}