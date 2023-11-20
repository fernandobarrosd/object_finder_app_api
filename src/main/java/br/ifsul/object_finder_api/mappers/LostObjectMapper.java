package br.ifsul.object_finder_api.mappers;

import br.ifsul.object_finder_api.dtos.CreateLostObjectDTO;
import br.ifsul.object_finder_api.entities.LostObject;
import br.ifsul.object_finder_api.utils.NumberUtils;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class LostObjectMapper {
    public LostObject toEntity(CreateLostObjectDTO createLostObjectDTO) {
        LostObject lostObject = new LostObject();

        LocalDate localDate = LocalDate.now();
        String day = NumberUtils.convertToTwoNumbers(localDate.getDayOfMonth());
        String month = NumberUtils.convertToTwoNumbers(localDate.getMonth().getValue());
        String year = String.valueOf(localDate.getYear());

        String date = String.format("%s/%s/%s", day, month, year);

        lostObject.setName(createLostObjectDTO.getName());
        lostObject.setDescription(createLostObjectDTO.getDescription());
        lostObject.setDevolvido("Não");
        lostObject.setDataCadastro(date);
        lostObject.setDataEncontrado(date);
        lostObject.setLocale(createLostObjectDTO.getLocale());

        return lostObject;

    }
}