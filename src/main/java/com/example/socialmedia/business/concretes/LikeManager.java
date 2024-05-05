package com.example.socialmedia.business.concretes;

import com.example.socialmedia.business.abstractt.LikeService;
import com.example.socialmedia.business.request.CreateLikeRequest;
import com.example.socialmedia.business.response.GetAllLikeResponse;
import com.example.socialmedia.business.response.GetByIdLikeResponse;
import com.example.socialmedia.business.rule.LikeRule;
import com.example.socialmedia.business.rule.PostRule;
import com.example.socialmedia.business.rule.UserBusinessRule;
import com.example.socialmedia.core.utilities.mapper.ModelMapperService;
import com.example.socialmedia.dataAccess.LikeRepository;
import com.example.socialmedia.entities.Like;
import com.example.socialmedia.entities.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class LikeManager implements LikeService {

    private LikeRepository likeRepository;
    private ModelMapperService modelMapperService;
    private LikeRule likeRule;
    private PostRule postRule;
    private UserBusinessRule userBusinessRule;

    @Override
    public List<GetAllLikeResponse> getAll() {
        List<Like> likes=this.likeRepository.findAll();
        List<GetAllLikeResponse> getAllLikeResponses=likes.stream().map(like -> this.modelMapperService.forResponse().map(like, GetAllLikeResponse.class)).collect(Collectors.toList());
        return getAllLikeResponses;
    }

    @Override
    public List<GetAllLikeResponse> getByUserName(String userName) {
        List<Like> likes=this.likeRepository.findLikesByUserName(userName);
        List<GetAllLikeResponse> getAllLikeResponses=likes.stream().map(like -> this.modelMapperService.forResponse().map(like, GetAllLikeResponse.class)).collect(Collectors.toList());
        return getAllLikeResponses;
    }

    @Override
    public GetByIdLikeResponse getById(int id) {
      //  this.likeRule.checkIfExistsId(id);
        Like like=this.likeRepository.findById(id).orElseThrow();
        GetByIdLikeResponse getByIdLikeResponse=this.modelMapperService.forResponse().map(like, GetByIdLikeResponse.class);
        return getByIdLikeResponse;
    }

    @Override
    public void add(CreateLikeRequest createLikeRequest){
        this.postRule.checkIfId(createLikeRequest.getPostId());
        this.userBusinessRule.checkIfExistsId(createLikeRequest.getUserId());
       Like like=this.modelMapperService.forRequest().map(createLikeRequest, Like.class);
       this.likeRepository.save(like);
    }

    @Override
    public void delete(int id) {
       this.likeRule.checkIfExistsId(id);
        this.likeRepository.deleteById(id);
    }
}
