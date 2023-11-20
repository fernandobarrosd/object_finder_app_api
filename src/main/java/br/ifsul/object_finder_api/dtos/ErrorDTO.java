package br.ifsul.object_finder_api.dtos;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ErrorDTO {
    private final String message;
    private final String path;
    private final Integer statusCode;
}
