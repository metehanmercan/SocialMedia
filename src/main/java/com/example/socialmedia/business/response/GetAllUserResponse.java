package com.example.socialmedia.business.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllUserResponse {

    private int id;

    private String email;

    private String name;

    private String password;
}
