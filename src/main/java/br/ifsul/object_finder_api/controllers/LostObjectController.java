package br.ifsul.object_finder_api.controllers;

import br.ifsul.object_finder_api.dtos.CreateLostObjectDTO;
import br.ifsul.object_finder_api.dtos.LostObjectDTO;
import br.ifsul.object_finder_api.services.LostObjectService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/objects")
public class LostObjectController {
    @Autowired
    private LostObjectService lostObjectService;

    @GetMapping("/{id}")
    public LostObjectDTO findById(@PathVariable("id") Long id) {
        return lostObjectService.findByID(id);
    }

    @PostMapping
    public void save(@RequestBody @Valid CreateLostObjectDTO createLostObjectDTO) {
        lostObjectService.save(createLostObjectDTO);
    }

}