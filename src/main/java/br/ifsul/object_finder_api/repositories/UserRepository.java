package br.ifsul.object_finder_api.repositories;

import br.ifsul.object_finder_api.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("SELECT u FROM User u WHERE u.email LIKE :email AND u.password LIKE :password")
    User findByEmailAndPassword(@Param("email") String email, @Param("password") String password);
}