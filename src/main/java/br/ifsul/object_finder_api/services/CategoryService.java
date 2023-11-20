package br.ifsul.object_finder_api.services;

import br.ifsul.object_finder_api.entities.Category;
import br.ifsul.object_finder_api.projections.CategoryNameProjection;
import br.ifsul.object_finder_api.repositories.CategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public Category findCategoryByName(String name) {
        Category category = categoryRepository.findByName(name);
        if (category != null) {
            return category;
        }
        throw new EntityNotFoundException("Categoria não encontrada");
    }

    public List<CategoryNameProjection> findAllCategoryNames() {
        return categoryRepository.findAllCategoryNames();
    }


}