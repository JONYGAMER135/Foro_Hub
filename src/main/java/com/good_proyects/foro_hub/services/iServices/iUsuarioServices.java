package com.proyects.foro_hub.services.iServices;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface iUsuarioServices {

    List<UsuarioDTO> findAll();
    Page<UsuarioDTO> paginate(Pageable pageable);
    UsuarioDTO findById(Integer id);
    UsuarioDTO save(UsuarioRegistroDTO usuarioRegistroDTO);
    UsuarioDTO update(Integer id, UsuarioRegistroDTO usuarioRegistroDTO);
//    Boolean delete(Integer id);
    ResponseEntity eliminarUsuario(Integer id);

}
