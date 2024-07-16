package com.proyects.foro_hub.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api/admin/usuario")
public class UsuarioController {

    @Autowired
    private iUsuarioServices usuarioServices;

    @GetMapping(value = "/list")
    private List<UsuarioDTO> findAll(){
        return usuarioServices.findAll();
    }

    @GetMapping
    public Page<UsuarioDTO> paginate(@PageableDefault(sort = "nombre", direction = Sort.Direction.ASC, size = 10) Pageable pageable) {
        return usuarioServices.paginate(pageable);
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    private UsuarioDTO findById(@PathVariable(value = "id") Integer id){
        return usuarioServices.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private UsuarioDTO save(@RequestBody @Valid UsuarioRegistroDTO usuarioRegistroDTO){
        return usuarioServices.save(usuarioRegistroDTO);
    }

    @PutMapping(value = "/{id}")
    private UsuarioDTO update(@PathVariable(value = "id") Integer id,@RequestBody @Valid UsuarioRegistroDTO usuarioRegistroDTO){
        return usuarioServices.update(id, usuarioRegistroDTO);
    }

//    @DeleteMapping(value = "/{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    Boolean delete(@PathVariable(value = "id") Integer id){
//        return usuarioServices.delete(id);
//    }

    @DeleteMapping(value = "/{id}")
    ResponseEntity<?> eliminarUsuario(@PathVariable(value = "id") Integer id){
        return usuarioServices.eliminarUsuario(id);
    }

}
