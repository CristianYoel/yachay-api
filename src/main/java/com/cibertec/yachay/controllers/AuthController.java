package com.cibertec.yachay.controllers;

import com.cibertec.yachay.dto.*;
import com.cibertec.yachay.entities.Usuario;
import com.cibertec.yachay.services.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@CrossOrigin("*")
public class AuthController {

    private final UsuarioService usuarioService;

    @PostMapping("/login")
    public LoginResponse login(
            @RequestBody LoginRequest request){

        Usuario u=
                usuarioService.login(
                        request.getCorreo(),
                        request.getClave()
                );

        return LoginResponse.builder()
                .idUsuario(u.getIdUsuario())
                .nombre(u.getNombre())
                .rol(u.getRol().name())
                .build();

    }

}