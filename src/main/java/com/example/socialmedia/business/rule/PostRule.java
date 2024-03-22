package com.example.socialmedia.business.rule;


import com.example.socialmedia.core.utilities.exception.BusinessException;
import com.example.socialmedia.dataAccess.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PostRule {
    private PostRepository postRepository;

    public void checkIfId(int id) {
        if (postRepository.existsById(id) == false) {
            throw new BusinessException("Post id dont found");
        }
    }

    public void checkIfTextContent(String textContent) {
        if (this.postRepository.existsByTextContent(textContent)){
            throw new BusinessException("The post description cannot be updated without modification.");
        }
    }

}
