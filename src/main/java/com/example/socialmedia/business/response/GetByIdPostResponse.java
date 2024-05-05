package com.example.socialmedia.business.response;

import com.example.socialmedia.entities.Like;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetByIdPostResponse {
    private String textContent;
    private String userName;


}
