package com.example.socialmedia.business.abstractt;

import com.example.socialmedia.business.request.CreateMessageRequest;
import com.example.socialmedia.business.response.GetAllMessageResponse;
import com.example.socialmedia.entities.Message;
import com.example.socialmedia.entities.User;

import java.util.List;
import java.util.Map;

public interface MessageService {

    List<GetAllMessageResponse> getAll();

    List<GetAllMessageResponse> getAllSender(String senderName);
    List<GetAllMessageResponse> getAllReceiver(String receiverName);
    void add(CreateMessageRequest createMessageRequest);

    void  delete(int id);

    Map<String, List<GetAllMessageResponse>> getMessagesByUser(String userName);
}
