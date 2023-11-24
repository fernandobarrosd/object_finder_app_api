package br.ifsul.object_finder_api.exception_handlers;

import br.ifsul.object_finder_api.dtos.ErrorDTO;
import br.ifsul.object_finder_api.mappers.ErrorDTOMapper;
import jakarta.persistence.EntityExistsException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class EntityExistsExceptionHandler {
    @Autowired
    private ErrorDTOMapper errorDTOMapper;

    @ExceptionHandler(EntityExistsException.class)
    private ResponseEntity<ErrorDTO> handlerEntityExists(EntityExistsException exception, HttpServletRequest request){
        ErrorDTO errorDTO = errorDTOMapper.toDTO(exception, request, HttpStatus.BAD_REQUEST);

        return ResponseEntity.badRequest().body(errorDTO);
    }
}