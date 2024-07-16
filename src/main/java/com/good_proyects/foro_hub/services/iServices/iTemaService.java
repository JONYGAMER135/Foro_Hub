package com.proyects.foro_hub.services.iServices;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface iTemaService {

    List<TemaDto> findAll();
    Page<TemaDto> paginate(Pageable pageable);
    TemaDto findById(Integer id);
    TemaDto save(TemaDto temaDto);
    TemaDto update(Integer id, TemaActualizarDTO temaActualizarDTO);
    Boolean delete(Integer id);

}
