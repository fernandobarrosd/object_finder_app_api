package br.ifsul.object_finder_api.exception_handlers;

import br.ifsul.object_finder_api.dtos.MethodArgumentNotValidErrorDTO;
import br.ifsul.object_finder_api.mappers.MethodArgumentNotValidErrorDTOMapper;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MethodArgumentNotValidExceptionHandler {
    @Autowired
    private MethodArgumentNotValidErrorDTOMapper methodArgumentNotValidErrorDTOMapper;


    @ExceptionHandler(MethodArgumentNotValidException.class)
    private ResponseEntity<MethodArgumentNotValidErrorDTO> handlerMethodArgumentNotValid(MethodArgumentNotValidException exception,
                                                                                         HttpServletRequest request) {
        MethodArgumentNotValidErrorDTO errorDTO = methodArgumentNotValidErrorDTOMapper.toDTO(exception, request, HttpStatus.NOT_FOUND);

        return ResponseEntity.badRequest().body(errorDTO);
    }

}