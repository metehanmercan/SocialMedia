package com.example.socialmedia.business.rule;

import com.example.socialmedia.core.utilities.exception.BusinessException;
import com.example.socialmedia.dataAccess.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
public class UserBusinessRule {

    private UserRepository userRepository;

    public void checkIfExistsName(String name) {
        if (userRepository.existsByName(name)) {
            throw new BusinessException("user name already exists.");
        }
    }

    public void checkIfExistsNamee(String name) {
        if (userRepository.existsByName(name) == false) {
            throw new BusinessException("user name dont found");
        }
    }

    public void checkIfExistsId(int id) {
        if (userRepository.existsById(id) == false) {
            throw new BusinessException(" user id dont found.");
        }

    }

    public void checkIfExistsPassword(String password) {
        if (this.userRepository.existsByPassword(password)) {
            throw new BusinessException("This password is already in use by another user.");
        }
    }
    public void  checkIfExistsEmail(String email){
        if (this.userRepository.existsByEmail(email)){
            throw new BusinessException("This email is already in use by another user.");
        }
    }
}
