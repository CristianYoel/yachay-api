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
    @Column(name="id_usuario")
    private Long idUsuario;

    @Column(nullable=false)
    private String nombre;

    @Column(nullable=false,unique=true)
    private String correo;

    @Column(nullable=false)
    private String clave;

    @Enumerated(EnumType.STRING)
    @Column(nullable=false)
    private Rol rol;

    @Column(nullable=false)
    private Boolean activo;

}
