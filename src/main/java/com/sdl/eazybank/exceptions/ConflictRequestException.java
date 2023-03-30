package com.sdl.eazybank.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@ResponseStatus(HttpStatus.CONFLICT)
public class ConflictRequestException extends RuntimeException{
    @Serial
    private static final long serialVersionUID = 6171978443681353425L;

    public ConflictRequestException(String message) {
        super(message);
    }
}
