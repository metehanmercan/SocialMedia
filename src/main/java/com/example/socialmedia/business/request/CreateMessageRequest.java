package com.example.socialmedia.business.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;


@Data
@AllArgsConstructor

public class CreateMessageRequest {


    @Size(min = 3, max = 100)
    private String content;

    private int senderId;

    private int receiverId;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")// localtime için gerekli
    private LocalDateTime date;


 /*public CreateMessageRequest() {
     this.date = LocalDateTime.now(); // Yerel saat dilimine göre tarih ve zaman alınır mesaj oluşurkenki saati otomatik çeker bu
    }*/


}


