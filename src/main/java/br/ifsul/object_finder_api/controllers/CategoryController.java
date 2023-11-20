package br.ifsul.object_finder_api.controllers;

import br.ifsul.object_finder_api.entities.Category;
import br.ifsul.object_finder_api.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;


    @GetMapping
    public @ResponseBody List<Category> findAll() {
        return categoryRepository.findAll();
    }
}