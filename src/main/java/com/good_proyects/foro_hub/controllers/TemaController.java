package com.proyects.foro_hub.controllers;
import java.util.List;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api")
public class TemaController {

    @Autowired
    private iTemaService temaService;

    @GetMapping(value = "/admin/topicos/list")
    private List<TemaDto> findAll(){
        return temaService.findAll();
    }

    @GetMapping(value = "/admin/topicos")
    private Page<TemaDto> paginate(@PageableDefault(sort = "createdAt",direction = Sort.Direction.ASC ,size = 10 ) Pageable pageable){
        return temaService.paginate(pageable);
    }

    @GetMapping(value = "/topicos/{id}")
    private TemaDto findById(@PathVariable(value = "id") Integer id){
        return temaService.findById(id);
    }

    @PostMapping(value = "/topicos")
    private TemaDto save(@RequestBody @Valid TemaDto temaDto){
        return temaService.save(temaDto);
    }

    @PutMapping(value = "/topicos/{id}")
    private TemaDto update(@PathVariable(value = "id") Integer id, @RequestBody @Valid TemaActualizarDTO temaActualizarDTO){
        return temaService.update(id,temaActualizarDTO);
    }

    @DeleteMapping(value = "/topicos/{id}")
    private Boolean delete(@PathVariable(value = "id") Integer id){
        return temaService.delete(id);
    }

}
