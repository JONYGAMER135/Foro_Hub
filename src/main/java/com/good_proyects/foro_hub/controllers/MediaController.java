package com.proyects.foro_hub.controllers;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/media")
public class MediaController implements iMediaController {

    @Autowired
    private iAlmacenamientoService almacenamientoService;

    @Override
    @PostMapping(value = "/upload")
    public Map<String, String> upload(@RequestParam(value = "file") MultipartFile multipartFile) {
        String path = almacenamientoService.almacenar(multipartFile);
        return Map.of("path", path);
    }

    @Override
    @GetMapping(value = "/{filename}")
    public ResponseEntity<Resource> getResource(@PathVariable(value = "filename") String nombreArchivo) throws IOException {
        Resource recurso = almacenamientoService.cargarRecurso(nombreArchivo);
        String contenType = Files.probeContentType(recurso.getFile().toPath());
        return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_TYPE,contenType)
                .body(recurso);
    }
}
