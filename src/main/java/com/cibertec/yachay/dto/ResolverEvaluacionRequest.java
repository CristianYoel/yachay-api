package com.cibertec.yachay.dto;

import lombok.Data;
import java.util.List;

@Data
public class ResolverEvaluacionRequest {

    private Long usuarioId;
    private Long temaId;

    private List<RespuestaDTO> respuestas;

}