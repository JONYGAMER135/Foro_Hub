package com.proyects.foro_hub.controllers;
import java.time.LocalDateTime;

import org.modelmapper.ModelMapper;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "/api")
@AllArgsConstructor
public class CuentaController {

    private final iUsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    @PostMapping(value = "/registro")
    public PerfilUsuarioDTO registro(@RequestBody @Validated UsuarioRegistroDTO usuarioRegistroDTO){
        boolean emailExists = usuarioRepository.existsByEmail(usuarioRegistroDTO.getEmail());
        if (emailExists){
            throw new BadRequestExcepton("ERROR EMAIL DUPLICADO: El email ya existe!");
        }
        //Usuario usuario = new Usuario();
        Usuario usuario = new ModelMapper().map(usuarioRegistroDTO,Usuario.class);
        usuario.setPassword(passwordEncoder.encode(usuarioRegistroDTO.getPassword()));
        usuario.setActivo(Boolean.TRUE);
        usuario.setRole(Role.USER);
        usuario.setCreatedAt(LocalDateTime.now());
        usuarioRepository.save(usuario);
//        usuario.setFilePerfil(usuarioRegistroDTO.getFilePerfil());
//        usuario.setNombre(usuarioRegistroDTO.getNombre());
//        usuario.setEmail(usuarioRegistroDTO.getEmail());

        //return new PerfilUsuarioDTO(usuario.getNombre(),usuario.getEmail(), usuario.getPassword(),usuario.getRole(), usuario.getId());
        return new ModelMapper().map(usuario, PerfilUsuarioDTO.class);
    }

}
