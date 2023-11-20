package br.ifsul.object_finder_api.dto;

import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginDTO {
    private String email;
    @Length(
        min = 1,
        max = 12,
        message = "Precisa ser uma senha no máximo 12 carácteres")
    private String password;
}
