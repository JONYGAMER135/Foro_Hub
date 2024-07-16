package com.proyects.foro_hub.services.iServices;
import java.time.LocalDate;
import java.util.List;

public interface iHomeService {

    List<TemaDto> findByGenero(Genero genero);
    List<TemaDto> getTemasByDate(LocalDate localDate);


}
