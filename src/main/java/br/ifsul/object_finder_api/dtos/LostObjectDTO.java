package br.ifsul.object_finder_api.dtos;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class LostObjectDTO {
    private final Long id;
    private final String name;
    private final String description;
    private final String category;
    private final String locale;
    private final String dataEncontrado;
    private final String dataCadastro;
    private final String devolvido;
}