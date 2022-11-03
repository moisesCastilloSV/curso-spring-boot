package org.mcastillo.springcloud.msvc.usuarios.msvcusuarios.controllers;

import org.mcastillo.springcloud.msvc.usuarios.msvcusuarios.models.entity.Usuario;
import org.mcastillo.springcloud.msvc.usuarios.msvcusuarios.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService service;

    @GetMapping("/listar-all")
    public List<Usuario> listar(){
        return service.listar();
    }

    @GetMapping("/listar-one/{id}")
    public ResponseEntity<?> listarUno(@PathVariable Long id){
        Optional<Usuario> optionalUsuario = service.porId(id);
        if (optionalUsuario.isPresent()){
            return ResponseEntity.ok(optionalUsuario.get());
        }
        return ResponseEntity.notFound().build();
    }

   @PostMapping
  // @ResponseStatus(HttpStatus.CREATED)
    public  ResponseEntity<?> Crear(@RequestBody Usuario usuario){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(usuario));

   }
   @PutMapping("/{id}")
    public ResponseEntity<?> Editar(@RequestBody Usuario usuario,@PathVariable Long id){

       Optional<Usuario> optionalUsuario = service.porId(id);
       if (optionalUsuario.isPresent()){
           Usuario usuarioDB=optionalUsuario.get();
           usuarioDB.setNombre(usuario.getNombre());
           usuarioDB.setEmail(usuario.getEmail());
           usuarioDB.setPassword(usuario.getPassword());

           return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(usuarioDB));
       }
       return ResponseEntity.notFound().build();
   }

   @DeleteMapping("/{id}")
    public ResponseEntity<?> Eliminar(@PathVariable Long id) {
       Optional<Usuario> optionalUsuario = service.porId(id);
       if (optionalUsuario.isPresent()){
           service.eliminar(id);
           return  ResponseEntity.noContent().build();
       }
       return ResponseEntity.notFound().build();
   }


}
