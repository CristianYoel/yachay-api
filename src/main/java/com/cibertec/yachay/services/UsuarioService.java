package com.cibertec.yachay.services;

import com.cibertec.yachay.entities.Usuario;
import com.cibertec.yachay.repositories.UsuarioRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepositorio usuarioRepositorio;

    public List<Usuario> listar() {
        return usuarioRepositorio.findAll();
    }

    public Usuario obtener(Long id) {
        return usuarioRepositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con id: " + id));
    }

    public Usuario crear(Usuario usuario) {
        return usuarioRepositorio.save(usuario);
    }

    public Usuario actualizar(Long id, Usuario usuario) {
        Usuario existente = obtener(id);
        existente.setNombre(usuario.getNombre());
        existente.setCorreo(usuario.getCorreo());
        existente.setClave(usuario.getClave());
        existente.setRol(usuario.getRol());
        return usuarioRepositorio.save(existente);
    }

    public Usuario login(String correo,String clave){

        return usuarioRepositorio
                .findByCorreoAndClave(correo,clave)
                .orElseThrow(
                        ()-> new RuntimeException("Credenciales incorrectas")
                );

    }

    public void eliminar(Long id) {
        usuarioRepositorio.deleteById(id);
    }
}