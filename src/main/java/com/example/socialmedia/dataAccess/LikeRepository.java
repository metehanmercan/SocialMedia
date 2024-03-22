package com.example.socialmedia.dataAccess;

import com.example.socialmedia.entities.Like;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LikeRepository extends JpaRepository<Like,Integer> {

    boolean existsById(int id);

    List<Like> findLikesByUserName(String userName); // bir kullanıcın beğendiği tüm postları cektik
}
