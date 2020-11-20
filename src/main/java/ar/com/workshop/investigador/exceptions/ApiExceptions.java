package ar.com.workshop.investigador.exceptions;

import org.springframework.http.HttpStatus;

public class ApiExceptions extends RuntimeException{

    private  HttpStatus httpStatus;
    public ApiExceptions(final String message, final HttpStatus code) {
        super(message);
        this.httpStatus = code;
    }
}
