package com.proyects.foro_hub.controllers;
import java.util.List;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api/respuesta")
public class RespuestaController {

    @Autowired
    private iRespuestaService respuestaService;

    @Autowired
    public RespuestaController(RespuestaService respuestaService) {
        this.respuestaService = respuestaService;
    }

    @GetMapping(value = "/list")
    List<RespuestaDTO> findAll(){
        return respuestaService.findAll();
    }

    @GetMapping("/{id}")
    public RespuestaDTO findById(@PathVariable(value = "id") Integer id){
        return respuestaService.findById(id);
    }

    @GetMapping
    Page<RespuestaDTO> paginate(@PageableDefault(sort ="createdAt",direction = Sort.Direction.DESC, size = 10) Pageable pageable){
        return respuestaService.paginate(pageable);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public RespuestaDTO save(@RequestBody @Valid RespuestaDTO respuestaDTO){
        return respuestaService.save(respuestaDTO);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping(value = "/{id}")
    RespuestaDTO update(@PathVariable(value = "id") Integer id, @RequestBody @Valid RespuestaDTO respuestaDTO){
        return respuestaService.update(id,respuestaDTO);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{id}")
    Boolean delete(@PathVariable(value = "id") Integer id){
        return respuestaService.delete(id);
    }


}
