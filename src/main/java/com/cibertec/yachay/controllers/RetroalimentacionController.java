package com.cibertec.yachay.controllers;

import com.cibertec.yachay.entities.Retroalimentacion;
import com.cibertec.yachay.services.RetroalimentacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/retroalimentaciones")
@RequiredArgsConstructor
public class RetroalimentacionController {

    private final RetroalimentacionService retroalimentacionService;

    @GetMapping
    public List<Retroalimentacion> listar() {
        return retroalimentacionService.listar();
    }

    @GetMapping("/tema/{idTema}")
    public List<Retroalimentacion> listarPorTema(@PathVariable Long idTema) {
        return retroalimentacionService.listarPorTema(idTema);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Retroalimentacion> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(retroalimentacionService.obtener(id));
    }

    @PostMapping
    public ResponseEntity<Retroalimentacion> crear(@RequestBody Retroalimentacion retro) {
        return ResponseEntity.ok(retroalimentacionService.crear(retro));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Retroalimentacion> actualizar(@PathVariable Long id, @RequestBody Retroalimentacion retro) {
        return ResponseEntity.ok(retroalimentacionService.actualizar(id, retro));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        retroalimentacionService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}