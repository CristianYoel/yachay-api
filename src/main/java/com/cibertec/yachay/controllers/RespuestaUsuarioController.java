package com.cibertec.yachay.controllers;

import com.cibertec.yachay.entities.RespuestaUsuario;
import com.cibertec.yachay.services.RespuestaUsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/respuestas")
@RequiredArgsConstructor
public class RespuestaUsuarioController {

    private final RespuestaUsuarioService respuestaUsuarioService;

    @GetMapping
    public List<RespuestaUsuario> listar() {
        return respuestaUsuarioService.listar();
    }

    @GetMapping("/evaluacion/{idEvaluacion}")
    public List<RespuestaUsuario> listarPorEvaluacion(@PathVariable Long idEvaluacion) {
        return respuestaUsuarioService.listarPorEvaluacion(idEvaluacion);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RespuestaUsuario> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(respuestaUsuarioService.obtener(id));
    }

    @PostMapping
    public ResponseEntity<RespuestaUsuario> crear(@RequestBody RespuestaUsuario respuesta) {
        return ResponseEntity.ok(respuestaUsuarioService.crear(respuesta));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RespuestaUsuario> actualizar(@PathVariable Long id, @RequestBody RespuestaUsuario respuesta) {
        return ResponseEntity.ok(respuestaUsuarioService.actualizar(id, respuesta));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        respuestaUsuarioService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}