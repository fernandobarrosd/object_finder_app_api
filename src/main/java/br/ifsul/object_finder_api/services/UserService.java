package br.ifsul.object_finder_api.services;

import br.ifsul.object_finder_api.dtos.LoginDTO;
import br.ifsul.object_finder_api.dtos.LostObjectDTO;
import br.ifsul.object_finder_api.entities.User;
import br.ifsul.object_finder_api.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public User findById(Long userID){
        return userRepository.findById(userID).orElseThrow(() ->
                new EntityNotFoundException("O usuário não foi encontrado"));
    }

    public User findUserByEmailAndPassword(LoginDTO loginDTO) {
        String email = loginDTO.getEmail();
        String password = loginDTO.getPassword();
        User user = userRepository.findByEmailAndPassword(email, password);
        if (user != null) {
            return user;
        }
        throw new EntityNotFoundException("O usuário não foi encontrado");
    }

    public List<LostObjectDTO> findAllObjects(Long userID) {
        User user = findById(userID);
        return user.getLostObjects()
        .stream()
        .map(lostObject -> new LostObjectDTO(
            lostObject.getId(),
            lostObject.getName(),
            lostObject.getDescription(),
            lostObject.getCategory().getName(),
            lostObject.getLocale(),
            lostObject.getDataEncontrado(),
            lostObject.getDataCadastro(),
            lostObject.getDevolvido()
        ))
        .toList();
    }
}