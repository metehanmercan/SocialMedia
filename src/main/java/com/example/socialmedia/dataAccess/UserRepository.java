package com.example.socialmedia.dataAccess;

import com.example.socialmedia.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    boolean existsByName(String name);

    boolean existsById(int id);

    boolean existsByEmail(String email);

    boolean existsByPassword(String password);

    List<User> findByNameContaining(String keyword);

    User findByName(String name);


}
