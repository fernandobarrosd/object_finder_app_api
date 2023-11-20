package br.ifsul.object_finder_api.services;

import br.ifsul.object_finder_api.dto.CreateLostObjectDTO;
import br.ifsul.object_finder_api.entities.Category;
import br.ifsul.object_finder_api.entities.LostObject;
import br.ifsul.object_finder_api.entities.User;
import br.ifsul.object_finder_api.repositories.LostObjectRepository;
import br.ifsul.object_finder_api.utils.NumberUtils;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class LostObjectService {
    @Autowired
    private LostObjectRepository lostObjectRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private CategoryService categoryService;



    public List<LostObject> findAll() {
        return lostObjectRepository.findAll();
    }

    public LostObject findByID(Integer id) {
        return lostObjectRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("O objeto não foi encontrado"));
    }

    public void save(CreateLostObjectDTO createLostObjectDTO) {
        Category category = categoryService.findByName(createLostObjectDTO.getCategory());
        User user = userService.findById(createLostObjectDTO.getUserID());

        LostObject lostObject = new LostObject();

        LocalDate localDate = LocalDate.now();
        String day = NumberUtils.convertToTwoNumbers(localDate.getDayOfMonth());
        String month = NumberUtils.convertToTwoNumbers(localDate.getMonth().getValue());
        String year = String.valueOf(localDate.getYear());

        String date = String.format("%s/%s/%s", day, month, year);

        lostObject.setId(null);
        lostObject.setName(createLostObjectDTO.getName());
        lostObject.setDescription(createLostObjectDTO.getDescription());
        lostObject.setUser(user);
        lostObject.setCategory(category);
        lostObject.setDevolvido("Não");
        lostObject.setDataCadastro(date);
        lostObject.setDataEncontrado(date);
        lostObject.setLocale(createLostObjectDTO.getLocale());

        lostObjectRepository.save(lostObject);
    }

}
