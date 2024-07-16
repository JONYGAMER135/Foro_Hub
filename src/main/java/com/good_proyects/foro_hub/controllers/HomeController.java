package com.proyects.foro_hub.controllers;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "/api/home")
@AllArgsConstructor
public class HomeController implements iHomeService {

    private final iTemaRepository temaRepository;

    @Override
    @GetMapping("/categoria/{genero}")
    public List<TemaDto> findByGenero(@PathVariable(value = "genero") Genero genero) {

        List<Tema> temas = temaRepository.findByGenero(genero);

        if (temas == null || temas.isEmpty()){
            throw new ResourceNotFoundException("Genero no encontrado!");
        }else {
            return temas.stream()
                    .map(this::manejorRespuestaClienteCorta)// Transforma cada Tema a TemaDto reducido
                    .collect(Collectors.toList());
        }
    }

    @GetMapping("/fecha/{date}")
    public List<TemaDto> getTemasByDate(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        List<Tema> temasPorFecha = temaRepository.findTemasByDate(date);

        if (temasPorFecha == null || temasPorFecha.isEmpty()){
            throw new ResourceNotFoundException("No hay Temas en la fecha ingresada!");
        }else {
            return temasPorFecha.stream()
                    .map(this::manejorRespuestaClienteCorta)// Transforma cada Tema a TemaDto reducido
                    .collect(Collectors.toList());
        }
    }

    @GetMapping("/last-temas")
    List<TemaDto> getLastTemas(){
        List<Tema> temas =temaRepository.findTop9ByOrderByCreatedAtDesc();

        if (temas == null || temas.isEmpty()){
            throw new ResourceNotFoundException("Temas no encontrados!");
        }else {
            return temas.stream()
                    .map(this::manejorRespuestaClienteCorta)// Transforma cada Tema a TemaDto reducido
                    .collect(Collectors.toList());
        }
    }

    @GetMapping("/topicos")
    private Page<TemaDto> paginate(@PageableDefault(sort = "createdAt",direction = Sort.Direction.ASC ,size = 10 ) Pageable pageable){
        Page<Tema> temas =temaRepository.findAll(pageable);
       return temas.map(this::manejorRespuestaClienteCorta);

    }

    private TemaDto manejorRespuestaClienteCorta(Tema tema) {
        TemaDto temaDto = new ModelMapper().map(tema, TemaDto.class);
        //TemaDto temaDto = new TemaDto();
//        temaDto.setId(tema.getId());
//        temaDto.setTitulo(tema.getTitulo());
//        temaDto.setMensaje(tema.getMensaje());
//        temaDto.setGenero(tema.getGenero());
//        temaDto.setUsuarioId(tema.getUsuarioId().getId());
//        temaDto.setUsuarioNombre(tema.getUsuarioId().getNombre());
          temaDto.setFilePerfil(tema.getUsuarioId().getFilePerfil());
//        temaDto.setCreatedAt(tema.getCreatedAt());
//        temaDto.setUpdatedAt(tema.getUpdatedAt());
//        temaDto.setActivo(tema.getActivo());
        //temaDto.setRespuestas(tema.getRespuestas()); // Aquí puedes ajustar según tus necesidades
        return temaDto;
    }
}
