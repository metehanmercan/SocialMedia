package com.example.socialmedia.business.rule;

import com.example.socialmedia.core.utilities.exception.BusinessException;
import com.example.socialmedia.dataAccess.LikeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LikeRule {
    private LikeRepository likeRepository;

    public void checkIfExistsId(int id){
        if (this.likeRepository.existsById(id)==false){
            throw new BusinessException("id dont found");
        }
    }
}
