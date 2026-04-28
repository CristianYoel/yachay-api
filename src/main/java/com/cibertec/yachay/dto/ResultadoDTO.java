package com.cibertec.yachay.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResultadoDTO {

    private Integer puntaje;
    private String feedback;

}