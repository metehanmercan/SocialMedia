package com.example.socialmedia.dataAccess;

import com.example.socialmedia.entities.Post;
import com.example.socialmedia.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Integer> {

    boolean existsById(int id);
    boolean existsByTextContent(String textContent);  // güncellemede aynı post acıklaması olmasın diye yaptık
   List<Post> findPostsByUserName(String userName); // Girilen isme göre o kullanıcıya ait tüm postlartını getirdik

}
