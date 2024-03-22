package com.example.socialmedia.business.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateLikeRequest {

    @NotNull
    private int userId;
    @NotNull
    private int postId;
}
