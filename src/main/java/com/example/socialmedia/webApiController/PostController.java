package com.example.socialmedia.webApiController;


import com.example.socialmedia.business.abstractt.PostService;
import com.example.socialmedia.business.request.CreatePostRequest;
import com.example.socialmedia.business.request.UpdatePostRequest;
import com.example.socialmedia.business.response.GetAllPostResponse;
import com.example.socialmedia.business.response.GetByIdPostResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController("/post")
public class PostController {
    private PostService postService;

    @GetMapping("/getAll")
    public List<GetAllPostResponse> getAll() {
        return this.postService.getAll();
    }

    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody @Valid CreatePostRequest createPostRequest) {
        this.postService.add(createPostRequest);
    }

    @DeleteMapping("/post/delete/{id}")
    public void delete(@PathVariable int id) {
        this.postService.delete(id);
    }

    @GetMapping("/getById/{id}")
    public GetByIdPostResponse getById(@PathVariable int id) {
        return this.postService.getById(id);
    }

    @PutMapping()
    public void update(UpdatePostRequest updatePostRequest) {
        this.postService.update(updatePostRequest);
    }

    @GetMapping("/posts/userName")
    public List<GetAllPostResponse> getByUserName(String userName){
       return this.postService.getByUserName(userName);
    }
}
