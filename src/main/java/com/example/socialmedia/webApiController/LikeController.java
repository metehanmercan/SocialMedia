package com.example.socialmedia.webApiController;

import com.example.socialmedia.business.abstractt.LikeService;
import com.example.socialmedia.business.request.CreateLikeRequest;
import com.example.socialmedia.business.response.GetAllLikeResponse;
import com.example.socialmedia.business.response.GetByIdLikeResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/likes")
@AllArgsConstructor

public class LikeController {
    private LikeService likeService;

    @GetMapping("getAll/like")
    public List<GetAllLikeResponse> getAll() {
        return this.likeService.getAll();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(CreateLikeRequest createLikeRequest) {
        this.likeService.add(createLikeRequest);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id) {
        this.likeService.delete(id);
    }

    @GetMapping("/getById/like/{id}")
    public GetByIdLikeResponse getById(@PathVariable int id) {
        return this.likeService.getById(id);
    }

    @GetMapping("/userName/likes")
    public List<GetAllLikeResponse> getByUserName(String userName){
        return this.likeService.getByUserName(userName);
    }
}
