package com.proyects.foro_hub.services.iServices;
import java.io.IOException;
import java.util.Map;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface iMediaController {

    Map<String, String> upload(MultipartFile multipartFile);
    ResponseEntity<Resource> getResource(String nombreArchivo) throws IOException;
}
