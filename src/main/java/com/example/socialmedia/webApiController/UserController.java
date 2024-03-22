package com.example.socialmedia.webApiController;

import com.example.socialmedia.business.abstractt.UserService;
import com.example.socialmedia.business.request.CreateUserRequest;
import com.example.socialmedia.business.request.UpdateUserRequest;
import com.example.socialmedia.business.response.GetAllUserResponse;
import com.example.socialmedia.business.response.GetByIdUserResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {

    private UserService userService;


    @GetMapping("/getAll")
    public List<GetAllUserResponse> getAll(){
        return this.userService.getAll();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody @Valid CreateUserRequest createUserRequest){
        this.userService.add(createUserRequest);
    }

    @GetMapping("/geyById/user/{id}")
    public GetByIdUserResponse geyById(@PathVariable int id){
        return this.userService.geyById(id);
    }

    @DeleteMapping("/delete/user/{id}")
    public void delete(@PathVariable int id){
        this.userService.delete(id);
    }

    @PutMapping
    public void update(UpdateUserRequest updateUserRequest){
        this.userService.update(updateUserRequest);
    }
    @GetMapping("/keyword")
    public List<GetAllUserResponse> keyword(@RequestParam(required = false) String keyword){
        return this.userService.search(keyword);
    }
}
