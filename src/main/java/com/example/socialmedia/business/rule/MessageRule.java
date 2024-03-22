package com.example.socialmedia.business.rule;


import com.example.socialmedia.core.utilities.exception.BusinessException;
import com.example.socialmedia.dataAccess.MessageRepository;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MessageRule {
    private MessageRepository messageRepository;

    public void checkIfSenderId(int senderId){
        if(!this.messageRepository.existsBySenderId(senderId)){
            throw new BusinessException("sender dont found");
        }
    }
    public void checkIfReceiverId(int receiverId){
        if(!this.messageRepository.existsByReceiverId(receiverId)){
            throw new BusinessException("receiver dont found");
        }
    }

    public void checkIfSenderName(String senderName){
        if (!this.messageRepository.existsBySenderName(senderName)){
            throw new BusinessException("SenderName dont found");
        }
    }
    public void checkIfReceiverName(String receiverName){
        if (!this.messageRepository.existsByReceiverName(receiverName)){
            throw new BusinessException("ReceiverName dont found");
        }
    }
    public void checkIfId(int id){
        if (!this.messageRepository.existsById(id)){}
        throw new BusinessException("id dont found");
    }
}
