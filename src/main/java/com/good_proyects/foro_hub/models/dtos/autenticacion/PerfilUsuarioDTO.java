package com.proyects.foro_hub.models.dtos.autenticacion;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PerfilUsuarioDTO {

    private Integer id;
    private String nombre;
    private String email;
    private String password;
    private Role role;
    private String filePerfil;

}
