package com.example.practicaSpringModel.configuration;

import com.example.practicaSpringModel.controller.nonexistentContentException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionContentHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler({nonexistentContentException.class})
    protected ResponseEntity<Object> handleNotFound(
            Exception ex, WebRequest request){
        return handleExceptionInternal(ex,"Content not found",
                new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }
}
