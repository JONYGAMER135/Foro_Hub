package com.proyects.foro_hub.controllers;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "/api")
@AllArgsConstructor
public class JWTController {

    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final ProveedorDeToken proveedorDeToken;
    private final iUsuarioRepository usuarioRepository;

    @PostMapping(value = "/autenticacion")
    public ResponseEntity<?> autenticacion(@RequestBody @Valid SolicitudAutenticacion solicitudAutenticacion){
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                solicitudAutenticacion.getEmail(),
                solicitudAutenticacion.getPassword()
        );

        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = proveedorDeToken.crearToken(authentication);
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.AUTHORIZATION, "Bearer "+ token);

        Usuario usuario = usuarioRepository
                .findByEmail(solicitudAutenticacion.getEmail())
                .orElseThrow(ResourceNotFoundException::new);

        RespuestaAutenticacion respuestaAutenticacion = new RespuestaAutenticacion(token, new PerfilUsuarioDTO(
                usuario.getId(),
                usuario.getNombre(),
                usuario.getEmail(),
                usuario.getPassword(),
                usuario.getRole(),
                usuario.getFilePerfil()
        ));

        return ResponseEntity
                .ok()
                .headers(headers)
                .body(respuestaAutenticacion);

    }

}
