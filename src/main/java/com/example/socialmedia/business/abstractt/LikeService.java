package com.example.socialmedia.business.abstractt;

import com.example.socialmedia.business.request.CreateLikeRequest;
import com.example.socialmedia.business.response.GetAllLikeResponse;
import com.example.socialmedia.business.response.GetByIdLikeResponse;
import com.example.socialmedia.core.utilities.exception.BusinessException;
import com.example.socialmedia.entities.User;

import java.util.List;

public interface LikeService {

    List<GetAllLikeResponse> getAll();

    List<GetAllLikeResponse> getByUserName(String userName);
    GetByIdLikeResponse getById(int id);

    void add(CreateLikeRequest createLikeRequest);

    void delete(int id);


}
