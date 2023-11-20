package br.ifsul.object_finder_api.handlers;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import br.ifsul.object_finder_api.dtos.ErrorDTO;
import br.ifsul.object_finder_api.dtos.MethodArgumentNotValidErrorDTO;
import br.ifsul.object_finder_api.mappers.ErrorDTOMapper;
import br.ifsul.object_finder_api.mappers.MethodArgumentNotValidErrorDTOMapper;

@RestControllerAdvice
public class HandlerExceptions {
    @Autowired
    private ErrorDTOMapper errorDTOMapper;

    @Autowired
    private MethodArgumentNotValidErrorDTOMapper methodArgumentNotValidErrorDTOMapper;

    @ExceptionHandler(EntityNotFoundException.class)
    private ResponseEntity<ErrorDTO> handlerEntityNotFound(EntityNotFoundException exception, HttpServletRequest request){
        ErrorDTO errorDTO = errorDTOMapper.toDTO(exception, request, HttpStatus.NOT_FOUND);

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDTO);
    }

    @ExceptionHandler(EntityExistsException.class)
    private ResponseEntity<ErrorDTO> handlerEntityExists(EntityExistsException exception, HttpServletRequest request){
        ErrorDTO errorDTO = errorDTOMapper.toDTO(exception, request, HttpStatus.BAD_REQUEST);

        return ResponseEntity.badRequest().body(errorDTO);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    private ResponseEntity<MethodArgumentNotValidErrorDTO> handlerMethodArgumentNotValid(MethodArgumentNotValidException exception, 
    HttpServletRequest request) {
        MethodArgumentNotValidErrorDTO errorDTO = methodArgumentNotValidErrorDTOMapper.toDTO(exception, request, HttpStatus.NOT_FOUND);

        return ResponseEntity.badRequest().body(errorDTO);
    }
}