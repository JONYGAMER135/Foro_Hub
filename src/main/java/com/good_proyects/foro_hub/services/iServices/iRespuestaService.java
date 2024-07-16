package com.proyects.foro_hub.services.iServices;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface iRespuestaService {

    List<RespuestaDTO> findAll();
    Page<RespuestaDTO> paginate(Pageable pageable);
    RespuestaDTO findById(Integer id);
    RespuestaDTO save(RespuestaDTO respuestaDTO);
    RespuestaDTO update(Integer id, RespuestaDTO respuestaDTO);
    Boolean delete(Integer id);

}
