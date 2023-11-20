package br.ifsul.object_finder_api.controllers;

import br.ifsul.object_finder_api.entities.Category;
import br.ifsul.object_finder_api.projections.CategoryNameProjection;
import br.ifsul.object_finder_api.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/{name}")
    public Category findCategoryByName(@PathVariable String name) {
        System.out.println(name);
        return categoryService.findCategoryByName(name);
    }


    @GetMapping
    public @ResponseBody Collection<CategoryNameProjection> findAllCategoryNames() {
        return categoryService.findAllCategoryNames();
    }
}