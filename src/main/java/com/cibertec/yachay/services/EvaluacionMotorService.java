package com.cibertec.yachay.services;

import com.cibertec.yachay.dto.*;
import com.cibertec.yachay.entities.*;
import com.cibertec.yachay.repositories.*;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EvaluacionMotorService {

    private final OpcionRespuestaRepositorio opcionRepo;
    private final RespuestaUsuarioRepositorio respuestaRepo;
    private final RetroalimentacionRepositorio retroRepo;

    public ResultadoDTO resolver(
            ResolverEvaluacionRequest request){

        int puntaje=0;

        for(RespuestaDTO r:
                request.getRespuestas()){

            OpcionRespuesta opcion=
                    opcionRepo.findById(
                            r.getOpcionId()
                    ).orElseThrow();

            if(opcion.getEsCorrecta()){

                puntaje+=25;

            }

        }

        String feedback;

        if(puntaje>=75){

            feedback="Excelente conocimiento";

        }
        else if(puntaje>=50){

            feedback="Buen nivel pero puedes mejorar";

        }
        else{

            feedback="Debes reforzar el tema";

        }

        return ResultadoDTO
                .builder()
                .puntaje(puntaje)
                .feedback(feedback)
                .build();

    }

}