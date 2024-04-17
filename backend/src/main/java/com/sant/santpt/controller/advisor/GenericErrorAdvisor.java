package com.sant.santpt.controller.advisor;

import com.sant.santpt.database.exception.RequiredRemainderAlreadyCalculatedException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;

@ControllerAdvice
@Slf4j
public class GenericErrorAdvisor extends ResponseEntityExceptionHandler {
    @ExceptionHandler({ RequiredRemainderAlreadyCalculatedException.class })
    public ResponseEntity<Object> handleRequiredRemainderAlreadyCalculatedException(Exception ex) {
        log.trace("Captured exception. Data already exists in database.");
        return new ResponseEntity<>(new HashMap<String, String>() {{
            put("error", ex.getClass().getName());
            put("message", ex.getMessage());
        }}, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({ NumberFormatException.class })
    public ResponseEntity<Object> handleNumberFormatException(Exception ex) {
        log.trace("Captured exception. Numbers are not correct for needed format.");
        return new ResponseEntity<>(new HashMap<String, String>() {{
            put("error", ex.getClass().getName());
            put("message", ex.getMessage());
        }}, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }
}
