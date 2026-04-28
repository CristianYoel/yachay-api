package com.cibertec.yachay.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="usuario")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuario {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idUsuario;

    private String nombre;

    @Column(nullable=false)
    private Boolean activo;

    @Column(unique=true)
    private String correo;

    private String clave;

    @Enumerated(EnumType.STRING)
    private Rol rol;

    //private Boolean activo;
}
