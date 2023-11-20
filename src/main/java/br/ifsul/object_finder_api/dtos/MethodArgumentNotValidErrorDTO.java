package br.ifsul.object_finder_api.dtos;

import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class MethodArgumentNotValidErrorDTO {
    private final String path;
    private final Integer statusCode;
    private final List<ErrorInfoDTO> errors;
}