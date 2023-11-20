package br.ifsul.object_finder_api.dtos;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class ErrorInfoDTO {
    private final String message;
}