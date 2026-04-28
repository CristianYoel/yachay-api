package com.cibertec.yachay.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse {

    private Long idUsuario;
    private String nombre;
    private String rol;
}