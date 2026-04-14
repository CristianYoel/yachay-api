package com.cibertec.yachay.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "progreso")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Progreso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_progreso")
    private Long idProgreso;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_evaluacion", nullable = false)
    private Evaluacion evaluacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pregunta_actual", nullable = false)
    private Pregunta preguntaActual;

    @Column(name = "puntaje_acumulado", nullable = false)
    private Integer puntajeAcumulado;

}
