package br.ifsul.object_finder_api.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@Getter
@RequiredArgsConstructor
public class LoginDTO {
    @NotEmpty(message = "O e-mail é obrigatório") 
    @Email(message = "Este campo precisa ser um e-mail")
    private final String email;

    @NotEmpty(message = "A senha é obrigatória")
    @Length(min = 1, max = 12, message = "A senha precisa ter no mínimo 1 caractére e no máximo 12")
    private final String password;
}