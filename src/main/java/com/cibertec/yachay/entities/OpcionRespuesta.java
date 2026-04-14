package com.cibertec.yachay.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "opcion_respuesta")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OpcionRespuesta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_opcion")
    private Long idOpcion;

    @Column(name = "texto", nullable = false, columnDefinition = "TEXT")
    private String texto;

    @Column(name = "peso", nullable = false)
    private Integer peso;

    @Column(name = "es_correcta", nullable = false)
    private Boolean esCorrecta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pregunta", nullable = false)
    private Pregunta pregunta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pregunta_siguiente")
    private Pregunta preguntaSiguiente;

}
