package com.example.socialmedia.business.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetByIdLikeResponse {
    private int id;
    private String textContent;
    private String postUserName;  // burası postu atan kişinin ismini getiriyor
    private String userName; // burası beğenen kullanıcıyı getiriyor
}
