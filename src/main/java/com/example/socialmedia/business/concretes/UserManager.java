package com.example.socialmedia.business.concretes;

import com.example.socialmedia.business.abstractt.UserService;
import com.example.socialmedia.business.request.CreateUserRequest;
import com.example.socialmedia.business.request.UpdateUserRequest;
import com.example.socialmedia.business.response.GetAllUserResponse;
import com.example.socialmedia.business.response.GetByIdUserResponse;
import com.example.socialmedia.business.rule.UserBusinessRule;
import com.example.socialmedia.core.utilities.mapper.ModelMapperService;
import com.example.socialmedia.dataAccess.UserRepository;
import com.example.socialmedia.entities.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class UserManager implements UserService {

    private UserRepository userRepository;
    private ModelMapperService modelMapperService;
    private UserBusinessRule userBusinessRule;

    @Override
    public List<GetAllUserResponse> getAll() {
        List<User> users=this.userRepository.findAll();
        List<GetAllUserResponse> getAllUserResponses=users.stream().map(user -> this.modelMapperService.forResponse().map(user, GetAllUserResponse.class)).collect(Collectors.toList());
        return getAllUserResponses;
    }

    @Override
    public GetByIdUserResponse geyById(int id) {
        this.userBusinessRule.checkIfExistsId(id);
        User user=this.userRepository.findById(id).orElseThrow();
        GetByIdUserResponse getByIdUserResponse=this.modelMapperService.forResponse().map(user,GetByIdUserResponse.class);

        return  getByIdUserResponse;
    }

    @Override
    public void add(CreateUserRequest createUserRequest) {
        this.userBusinessRule.checkIfExistsName(createUserRequest.getName());
        User user=this.modelMapperService.forRequest().map(createUserRequest, User.class);
       this.userRepository.save(user);

    }

    @Override
    public void delete(int id) {
        this.userBusinessRule.checkIfExistsId(id);
        this.userRepository.deleteById(id);
    }

    @Override
    public void update(UpdateUserRequest updateUserRequest) {
        this.userBusinessRule.checkIfExistsId(updateUserRequest.getId());
        User user=this.modelMapperService.forRequest().map(updateUserRequest, User.class);
        this.userRepository.save(user);
    }

    @Override
    public List<GetAllUserResponse> search(String keyword) {
        if(keyword!=null){
            List<User> users=this.userRepository.findByNameContaining(keyword);
            List<GetAllUserResponse> getAllUserResponses=users.stream().map(user -> this.modelMapperService.forResponse().map(user, GetAllUserResponse.class)).collect(Collectors.toList());
            return getAllUserResponses;
        }else{
            List<User> users=this.userRepository.findAll();
            List<GetAllUserResponse> getAllUserResponses=users.stream().map(user -> this.modelMapperService.forResponse().map(user, GetAllUserResponse.class)).collect(Collectors.toList());
            return getAllUserResponses;
        }

    }
}
