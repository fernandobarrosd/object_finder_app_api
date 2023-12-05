package br.ifsul.object_finder_api.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CreateLostObjectDTO {
    @NotEmpty(message = "O nome é obrigatório")
    private final String name;

    @NotEmpty(message = "A descricção é obrigatória")
    private final String description;


    @NotEmpty(message = "A localização é obrigatória")
    private final String locale;


    @NotEmpty(message = "O nome da categoria é obrigatório")
    private final String category;

    @NotNull(message = "O id do usuário é obrigatório")
    private final Long userID;
    
    @NotNull(message = "A data encontrado é obrigatória")
    private final String foundedDate;

}