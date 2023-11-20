package br.ifsul.object_finder_api.services;

import br.ifsul.object_finder_api.dtos.CreateLostObjectDTO;
import br.ifsul.object_finder_api.dtos.LostObjectDTO;
import br.ifsul.object_finder_api.entities.Category;
import br.ifsul.object_finder_api.entities.LostObject;
import br.ifsul.object_finder_api.entities.User;
import br.ifsul.object_finder_api.mappers.LostObjectMapper;
import br.ifsul.object_finder_api.repositories.LostObjectRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LostObjectService {
    @Autowired
    private LostObjectRepository lostObjectRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private LostObjectMapper lostObjectMapper;

    public LostObjectDTO findByID(Long id) {
        LostObject lostObject = lostObjectRepository.findById(id)
        .orElseThrow(() ->
                new EntityNotFoundException("O objeto não foi encontrado"));
        return new LostObjectDTO(id, lostObject.getName(),
        lostObject.getDescription(), lostObject.getCategory().getName(),
        lostObject.getLocale(), lostObject.getDataEncontrado(), lostObject.getDataCadastro(),
        lostObject.getDevolvido());
    }

    public void save(CreateLostObjectDTO createLostObjectDTO) {
        Category category = categoryService.findCategoryByName(createLostObjectDTO.getCategory());
        User user = userService.findById(createLostObjectDTO.getUserID());

        LostObject lostObject = lostObjectMapper.toEntity(createLostObjectDTO);

        lostObject.setUser(user);
        lostObject.setCategory(category);

        lostObjectRepository.save(lostObject);
    }

}
