package com.sant.santpt.controller.advisor;

import com.sant.santpt.database.exception.RequiredRemainderAlreadyCalculatedException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;

@ControllerAdvice
public class DatabaseErrorAdvisor extends ResponseEntityExceptionHandler {
    @ExceptionHandler({ RequiredRemainderAlreadyCalculatedException.class })
    public ResponseEntity<Object> handleRequiredRemainderAlreadyCalculatedException(Exception ex, WebRequest request) {
        return new ResponseEntity<>(new HashMap<String, String>() {{
            put("error", ex.getClass().getName());
            put("message", ex.getMessage());
        }}, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }
}
