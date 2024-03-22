package com.example.socialmedia.business.abstractt;

import com.example.socialmedia.business.request.CreateUserRequest;
import com.example.socialmedia.business.request.UpdateUserRequest;
import com.example.socialmedia.business.response.GetAllUserResponse;
import com.example.socialmedia.business.response.GetByIdUserResponse;
import com.example.socialmedia.entities.User;

import java.util.List;

public interface UserService {

    List<GetAllUserResponse> getAll();

    GetByIdUserResponse geyById(int id);
    void add(CreateUserRequest createUserRequest);

    void delete(int id);

    void update(UpdateUserRequest updateUserRequest);

    List<GetAllUserResponse> search(String keyword);
}
