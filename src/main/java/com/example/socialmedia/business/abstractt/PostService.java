package com.example.socialmedia.business.abstractt;

import com.example.socialmedia.business.request.CreatePostRequest;
import com.example.socialmedia.business.request.UpdatePostRequest;
import com.example.socialmedia.business.response.GetAllPostResponse;
import com.example.socialmedia.business.response.GetByIdPostResponse;

import java.util.List;

public interface PostService {

   List<GetAllPostResponse> getAll();

   List<GetAllPostResponse> getByUserName(String UserName);

   GetByIdPostResponse getById(int id);

   void add(CreatePostRequest createPostRequest);
   void  delete(int id);

   void update(UpdatePostRequest updatePostRequest);
}
