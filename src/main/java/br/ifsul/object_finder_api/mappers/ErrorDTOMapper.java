package br.ifsul.object_finder_api.mappers;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import br.ifsul.object_finder_api.dtos.ErrorDTO;
import jakarta.servlet.http.HttpServletRequest;

@Component
public class ErrorDTOMapper {
    public ErrorDTO toDTO(Exception exception, HttpServletRequest request, HttpStatus status) {
        String message = exception.getMessage();
        String path = request.getRequestURI();
        Integer statusCode = status.value();

        return new ErrorDTO(message, path, statusCode);
    }
}
