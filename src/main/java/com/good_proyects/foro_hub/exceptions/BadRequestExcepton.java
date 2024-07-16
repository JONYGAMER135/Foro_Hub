package com.proyects.foro_hub.exceptions;
import java.io.IOException;

import org.springframework.dao.DataAccessException;

public class BadRequestExcepton extends RuntimeException{

    public BadRequestExcepton(String s) {
        super(s);
    }
    public BadRequestExcepton(String s, DataAccessException e) {
        super(s,e);
    }

    public BadRequestExcepton(String s, IOException e) {
        super(s,e);
    }
}
