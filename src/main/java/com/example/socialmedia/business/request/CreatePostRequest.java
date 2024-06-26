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
public class CreatePostRequest {
    @NotBlank
    @NotNull
    @Size(min = 3,max = 200)
    private String textContent;


    @NotNull
    private int userId;
}
