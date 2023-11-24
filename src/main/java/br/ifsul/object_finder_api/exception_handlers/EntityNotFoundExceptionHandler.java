package br.ifsul.object_finder_api.exception_handlers;

import br.ifsul.object_finder_api.dtos.ErrorDTO;
import br.ifsul.object_finder_api.mappers.ErrorDTOMapper;
import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class EntityNotFoundExceptionHandler {
    @Autowired
    private ErrorDTOMapper errorDTOMapper;

    @ExceptionHandler(EntityNotFoundException.class)
    private ResponseEntity<ErrorDTO> handlerEntityNotFound(EntityNotFoundException exception, HttpServletRequest request){
        ErrorDTO errorDTO = errorDTOMapper.toDTO(exception, request, HttpStatus.NOT_FOUND);

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDTO);
    }
}