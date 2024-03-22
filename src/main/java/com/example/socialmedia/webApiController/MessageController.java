package com.example.socialmedia.webApiController;

import com.example.socialmedia.business.abstractt.MessageService;
import com.example.socialmedia.business.request.CreateMessageRequest;
import com.example.socialmedia.business.response.GetAllMessageResponse;
import com.example.socialmedia.core.utilities.mapper.ModelMapperService;
import com.example.socialmedia.entities.Message;
import com.example.socialmedia.entities.User;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController("/message/controller")
@AllArgsConstructor
public class MessageController {
    private MessageService messageService;
    private ModelMapperService modelMapperService;

    @GetMapping("/message/getAll")
    public List<GetAllMessageResponse> getAll() {
        return this.messageService.getAll();
    }

    @PostMapping("/message/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(CreateMessageRequest createMessageRequest) {
        this.messageService.add(createMessageRequest);
    }

    @DeleteMapping("/delete/message/{id}")
    public void delete(@PathVariable int id) {
        this.messageService.delete(id);
    }

    @GetMapping("/sender/messages")
    public List<GetAllMessageResponse> getAll(String senderName) {
        return this.messageService.getAllSender(senderName);
    }

    @GetMapping("/receiver/messages")
    public List<GetAllMessageResponse> getAllReceiver(String receiverName) {
        return this.messageService.getAllReceiver(receiverName);
    }
    @GetMapping("/user/{userName}")
    public ResponseEntity<Map<String, List<GetAllMessageResponse>>> getMessagesByUser(@PathVariable String userName) {
        Map<String, List<GetAllMessageResponse>> messagesByUser = messageService.getMessagesByUser(userName);
        return ResponseEntity.ok(messagesByUser);
    }

}

