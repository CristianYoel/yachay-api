package com.cibertec.yachay.services;

import com.cibertec.yachay.entities.OpcionRespuesta;
import com.cibertec.yachay.repositories.OpcionRespuestaRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OpcionRespuestaService {

    private final OpcionRespuestaRepositorio opcionRespuestaRepositorio;

    public List<OpcionRespuesta> listar() {
        return opcionRespuestaRepositorio.findAll();
    }

    public List<OpcionRespuesta> listarPorPregunta(Long idPregunta) {
        return opcionRespuestaRepositorio.findByPreguntaIdPregunta(idPregunta);
    }

    public OpcionRespuesta obtener(Long id) {
        return opcionRespuestaRepositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Opción no encontrada con id: " + id));
    }

    public OpcionRespuesta crear(
            OpcionRespuesta opcion
    ){

        Long idPregunta=
                opcion.getPregunta()
                        .getIdPregunta();

        long cantidad=
                opcionRespuestaRepositorio
                        .countByPreguntaIdPregunta(
                                idPregunta
                        );

        if(cantidad>=4){

            throw new RuntimeException(
                    "Solo 4 opciones por pregunta"
            );

        }

        return opcionRespuestaRepositorio.save(
                opcion
        );

    }

    public OpcionRespuesta actualizar(
            Long id,
            OpcionRespuesta opcion
    ){

        OpcionRespuesta existente=
                obtener(id);

        existente.setTexto(
                opcion.getTexto()
        );

        existente.setPeso(
                opcion.getPeso()
        );

        existente.setEsCorrecta(
                opcion.getEsCorrecta()
        );

        existente.setPregunta(
                opcion.getPregunta()
        );

        return opcionRespuestaRepositorio.save(
                existente
        );

    }


    @Transactional
    public void eliminar(Long id){

        if(
                !opcionRespuestaRepositorio.existsById(id)
        ){
            throw new RuntimeException(
                    "Opción no existe"
            );
        }

        opcionRespuestaRepositorio.deleteById(id);

    }

}