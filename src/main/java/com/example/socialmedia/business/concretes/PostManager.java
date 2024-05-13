package com.example.socialmedia.business.concretes;

import com.example.socialmedia.business.abstractt.PostService;
import com.example.socialmedia.business.request.CreatePostRequest;
import com.example.socialmedia.business.request.UpdatePostRequest;
import com.example.socialmedia.business.response.GetAllPostResponse;
import com.example.socialmedia.business.response.GetByIdPostResponse;
import com.example.socialmedia.business.rule.PostRule;
import com.example.socialmedia.business.rule.UserBusinessRule;
import com.example.socialmedia.core.utilities.mapper.ModelMapperService;
import com.example.socialmedia.dataAccess.PostRepository;
import com.example.socialmedia.entities.Post;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class PostManager implements PostService {
    private PostRepository postRepository;
    private ModelMapperService modelMapperService;
    private PostRule postRule;
    private UserBusinessRule userBusinessRule;

    @Override
    public List<GetAllPostResponse> getAll() {
        List<Post> posts = this.postRepository.findAll();
        List<GetAllPostResponse> getAllPostResponses = posts.stream().map(post -> this.modelMapperService.forResponse().map(post, GetAllPostResponse.class)).collect(Collectors.toList());
        return getAllPostResponses;
    }

    @Override
    public List<GetAllPostResponse> getByUserName(String userName) {
      this.userBusinessRule.checkIfExistsNamee(userName);
        List<Post> posts=this.postRepository.findPostsByUserName(userName);
        List<GetAllPostResponse> getAllPostResponses=posts.stream().map(post -> this.modelMapperService.forResponse().map(post,GetAllPostResponse.class)).collect(Collectors.toList());
        return getAllPostResponses;
    }

    @Override
    public GetByIdPostResponse getById(int id) {
        this.postRule.checkIfId(id);
        Post post=this.postRepository.findById(id).orElseThrow();
        GetByIdPostResponse getByIdPostResponse=this.modelMapperService.forResponse().map(post,GetByIdPostResponse.class);
        return getByIdPostResponse;
    }

    @Override
    public void add(CreatePostRequest createPostRequest) {
       this.userBusinessRule.checkIfExistsId(createPostRequest.getUserId());
        Post post=this.modelMapperService.forRequest().map(createPostRequest,Post.class);
        this.postRepository.save(post);
    }

    @Override
    public void delete(int id) {
       this.postRule.checkIfId(id);
        this.postRepository.deleteById(id);
    }

    @Override
    public void update(UpdatePostRequest updatePostRequest) {
        this.postRule.checkIfTextContent(updatePostRequest.getTextContent());
        this.userBusinessRule.checkIfExistsId(updatePostRequest.getUserId());
       this.postRule.checkIfId(updatePostRequest.getId());
        Post post=this.modelMapperService.forRequest().map(updatePostRequest, Post.class);
        this.postRepository.save(post);
    }
}
