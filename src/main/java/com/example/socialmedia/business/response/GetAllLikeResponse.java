package com.example.socialmedia.business.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllLikeResponse {

    private String postTextContent;
    private String postUserName;
    private String userName;
}
