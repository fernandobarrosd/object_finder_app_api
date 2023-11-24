package br.ifsul.object_finder_api.controllers;

import br.ifsul.object_finder_api.entities.Category;
import br.ifsul.object_finder_api.projections.CategoryNameProjection;
import br.ifsul.object_finder_api.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/{name}")
    public Category findCategoryByName(@PathVariable String name) {
        return categoryService.findCategoryByName(name);
    }


    @GetMapping
    public @ResponseBody List<CategoryNameProjection> findAllCategoryNames() {
        return categoryService.findAllCategoryNames();
    }
}