package com.example.socialmedia.business.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllMessageResponse {


    private int id;
    private String content;
    private String senderName;
    private String receiverName;
    private LocalDateTime creationDate;
}
