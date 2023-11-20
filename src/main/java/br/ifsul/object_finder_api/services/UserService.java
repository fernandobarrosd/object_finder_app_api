package br.ifsul.object_finder_api.services;

import br.ifsul.object_finder_api.dto.LoginDTO;
import br.ifsul.object_finder_api.entities.User;
import br.ifsul.object_finder_api.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public User findById(Integer id){
        return userRepository.findById(id).orElseThrow(() ->
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
}
