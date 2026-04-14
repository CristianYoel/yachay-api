package com.cibertec.yachay.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "respuesta_usuario")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RespuestaUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_respuesta")
    private Long idRespuesta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_evaluacion", nullable = false)
    private Evaluacion evaluacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pregunta", nullable = false)
    private Pregunta pregunta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_opcion", nullable = false)
    private OpcionRespuesta opcionRespuesta;

    @Column(name = "peso_obtenido", nullable = false)
    private Integer pesoObtenido;

}
