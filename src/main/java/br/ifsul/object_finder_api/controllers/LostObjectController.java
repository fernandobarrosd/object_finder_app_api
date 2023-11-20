package br.ifsul.object_finder_api.controllers;

import br.ifsul.object_finder_api.dto.CreateLostObjectDTO;
import br.ifsul.object_finder_api.entities.LostObject;
import br.ifsul.object_finder_api.services.LostObjectService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/objects")
public class LostObjectController {
    @Autowired
    private LostObjectService lostObjectService;
    @GetMapping
    private @ResponseBody List<LostObject> findAll() {
        return lostObjectService.findAll();
    }

    @GetMapping("/{id}")
    private @ResponseBody LostObject findById(@PathVariable("id") Integer id) {
        return lostObjectService.findByID(id);
    }

    @PostMapping
    private void save(@RequestBody @Valid CreateLostObjectDTO createLostObjectDTO) {
        lostObjectService.save(createLostObjectDTO);
    }
}