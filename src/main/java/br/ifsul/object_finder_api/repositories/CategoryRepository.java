package br.ifsul.object_finder_api.repositories;

import br.ifsul.object_finder_api.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    @Query(nativeQuery = true, value = "SELECT * FROM categorias WHERE nomecat = :name LIMIT 1")
    Category findByName(String name);
}