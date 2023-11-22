package br.ifsul.object_finder_api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.ifsul.object_finder_api.dtos.LoginDTO;
import br.ifsul.object_finder_api.dtos.LostObjectDTO;
import br.ifsul.object_finder_api.entities.User;
import br.ifsul.object_finder_api.services.UserService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Long> findByEmailAndPassword(@RequestBody @Valid LoginDTO loginDTO)  {
        User user = userService.findUserByEmailAndPassword(loginDTO);
        return ResponseEntity.status(HttpStatus.OK).body(user.getId());
    }

    @GetMapping("/{userID}/objects")
    public ResponseEntity<List<LostObjectDTO>> findAllLostObjects(@PathVariable Long userID) {
        return ResponseEntity.ok().body(userService.findAllObjects(userID));
    }
}