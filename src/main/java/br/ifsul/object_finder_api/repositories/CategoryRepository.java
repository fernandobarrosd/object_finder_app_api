package br.ifsul.object_finder_api.repositories;

import br.ifsul.object_finder_api.entities.Category;
import br.ifsul.object_finder_api.projections.CategoryNameProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    @Query("SELECT c FROM Category c WHERE c.name = :name")
    Category findByName(String name);

    @Query("SELECT c.name as name FROM Category c")
    List<CategoryNameProjection> findAllCategoryNames();
}