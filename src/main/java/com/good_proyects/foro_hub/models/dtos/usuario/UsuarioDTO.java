package com.proyects.foro_hub.models.dtos.usuario;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class UsuarioDTO {

    private Integer id;
    private String nombre;
    private String email;
    private String password;
    private Role role;
    private String filePerfil;
    private Boolean activo;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
