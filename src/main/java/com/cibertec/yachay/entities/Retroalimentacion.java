package com.cibertec.yachay.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "retroalimentacion")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Retroalimentacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_retro")
    private Long idRetro;

    @Column(name = "puntaje_min", nullable = false)
    private Integer puntajeMin;

    @Column(name = "puntaje_max", nullable = false)
    private Integer puntajeMax;

    @Column(name = "mensaje", nullable = false, columnDefinition = "TEXT")
    private String mensaje;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tema", nullable = false)
    private Tema tema;

}
