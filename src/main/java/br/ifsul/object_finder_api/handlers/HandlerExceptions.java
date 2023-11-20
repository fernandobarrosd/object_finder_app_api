package br.ifsul.object_finder_api.handlers;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class HandlerExceptions {
    @ExceptionHandler(EntityNotFoundException.class)
    private ResponseEntity<Map<String, Object>> handlerEntityNotFound(EntityNotFoundException e){
        Map<String, Object> requestError = new HashMap<>();
        requestError.put(e.getMessage(), HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(requestError);
    }

    @ExceptionHandler(EntityExistsException.class)
    private ResponseEntity<Map<String, Object>> handlerEntityExists(EntityExistsException e){
        Map<String, Object> requestError = new HashMap<>();
        requestError.put(e.getMessage(), HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(requestError);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    private ResponseEntity<Map<String, Object>> handlerEntityExists(MethodArgumentNotValidException e){
        Map<String, Object> requestError = new HashMap<>();
        requestError.put("Os campos estão inválidos", HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(requestError);
    }
}
