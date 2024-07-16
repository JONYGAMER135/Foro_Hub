package com.proyects.foro_hub.models.dtos.usuario;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UsuarioRegistroDTO {

    @NotNull
    @Size(min = 3, message = "Nombre debe tener almenos 3 caracteres!")
    @Size(max = 45, message = "Nombre puede tener maximo 45 caracteres!")
    private String nombre;

    @NotNull
    @Email
    private String email;

    @NotEmpty
    @Pattern(regexp = "[a-z0-9-]+")
    @Size(min = 5, message = "El password debe tener al menos 5 caracteres!")
    private String password;

//    @NotNull
   private Role role;

    @NotEmpty
    private String filePerfil;

}
