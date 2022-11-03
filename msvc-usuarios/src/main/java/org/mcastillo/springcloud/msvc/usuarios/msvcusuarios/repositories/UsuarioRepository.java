package org.mcastillo.springcloud.msvc.usuarios.msvcusuarios.repositories;

import org.mcastillo.springcloud.msvc.usuarios.msvcusuarios.models.entity.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario,Long> {

}
