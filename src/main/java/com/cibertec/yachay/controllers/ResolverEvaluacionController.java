package com.cibertec.yachay.controllers;

import com.cibertec.yachay.dto.*;
import com.cibertec.yachay.services.EvaluacionMotorService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/resolver")
@RequiredArgsConstructor
public class ResolverEvaluacionController {

    private final EvaluacionMotorService service;

    @PostMapping
    public ResultadoDTO resolver(
            @RequestBody ResolverEvaluacionRequest req
    ){
        return service.resolver(req);
    }

}