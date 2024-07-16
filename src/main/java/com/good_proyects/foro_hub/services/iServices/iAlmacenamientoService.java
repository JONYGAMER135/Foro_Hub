package com.proyects.foro_hub.services.iServices;
import java.nio.file.Path;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface iAlmacenamientoService {
    void iniciar();
    String almacenar(MultipartFile archivo);
    Path cargar(String nombreArchivo);
    Resource cargarRecurso(String nombreArchivo);
    void eliminarRecurso(String nombreArchivo);

}
