package com.proyects.foro_hub.models.dtos.autenticacion;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SolicitudAutenticacion {

    @NotNull
    @NotBlank
    @Email
    private String email;

    @NotEmpty
    @NotBlank
    @Pattern(regexp = "[a-z0-9-]+")
    @Size(min = 5, message = "El password debe tener al menos 5 caracteres!")
    private String password;
}
