package com.example.socialmedia.business.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequest {

@NotBlank
@NotNull
@Size(min = 3,max = 25)
    private String name;

    @NotBlank
    @NotNull
    @Size(min = 3,max = 25)

    private String email;

    @NotBlank
    @NotNull
    @Size(min = 3,max = 25)
    private  String password;

}
