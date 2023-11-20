package br.ifsul.object_finder_api.controllers;

import br.ifsul.object_finder_api.dto.LoginDTO;
import br.ifsul.object_finder_api.entities.User;
import br.ifsul.object_finder_api.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<User> findById(@PathVariable("id") Integer id) {
        User user = userService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<Integer> findByEmailAndPassword(@RequestBody @Valid LoginDTO loginDTO)  {
        User user = userService.findUserByEmailAndPassword(loginDTO);
        return ResponseEntity.status(HttpStatus.OK).body(user.getId());
    }
}
