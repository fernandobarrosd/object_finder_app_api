package br.ifsul.object_finder_api.mappers;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.MethodArgumentNotValidException;
import br.ifsul.object_finder_api.dtos.ErrorInfoDTO;
import br.ifsul.object_finder_api.dtos.MethodArgumentNotValidErrorDTO;
import jakarta.servlet.http.HttpServletRequest;

@Component
public class MethodArgumentNotValidErrorDTOMapper {
    public MethodArgumentNotValidErrorDTO toDTO(MethodArgumentNotValidException exception, HttpServletRequest request, 
    HttpStatus status) {
        String path = request.getRequestURI();
        Integer statusCode = status.value();
        List<ErrorInfoDTO> errors = exception.getAllErrors()
        .stream()
        .map(error -> new ErrorInfoDTO(error.getDefaultMessage()))
        .toList();

        return new MethodArgumentNotValidErrorDTO(path, statusCode, errors);
    }
}