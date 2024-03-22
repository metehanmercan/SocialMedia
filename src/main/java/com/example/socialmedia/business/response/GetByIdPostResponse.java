package com.example.socialmedia.business.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetByIdPostResponse {
    private String textContent;
    private String userName;
}
