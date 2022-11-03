package org.mcastillo.springcloud.msvc.usuarios.msvcusuarios.services;

import org.mcastillo.springcloud.msvc.usuarios.msvcusuarios.models.entity.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {
List<Usuario> listar();
Optional<Usuario> porId(long id);
Usuario guardar(Usuario usuario);
void eliminar(long id);


}

