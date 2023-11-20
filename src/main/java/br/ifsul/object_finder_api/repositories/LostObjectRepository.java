package br.ifsul.object_finder_api.repositories;

import br.ifsul.object_finder_api.entities.LostObject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LostObjectRepository extends JpaRepository<LostObject, Integer> {}