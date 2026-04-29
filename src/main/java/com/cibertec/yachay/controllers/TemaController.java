package com.cibertec.yachay.controllers;

import com.cibertec.yachay.entities.Tema;
import com.cibertec.yachay.services.TemaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/temas")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class TemaController {

    private final TemaService temaService;

    @GetMapping
    public List<Tema> listar() {
        return temaService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tema> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(temaService.obtener(id));
    }

    @PostMapping
    public ResponseEntity<Tema> crear(@RequestBody Tema tema) {
        return ResponseEntity.ok(temaService.crear(tema));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tema> actualizar(@PathVariable Long id, @RequestBody Tema tema) {
        return ResponseEntity.ok(temaService.actualizar(id, tema));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        temaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}