package com.example.socialmedia.business.concretes;

import com.example.socialmedia.business.abstractt.MessageService;
import com.example.socialmedia.business.request.CreateMessageRequest;
import com.example.socialmedia.business.response.GetAllMessageResponse;
import com.example.socialmedia.business.rule.MessageRule;
import com.example.socialmedia.core.utilities.mapper.ModelMapperService;
import com.example.socialmedia.dataAccess.MessageRepository;
import com.example.socialmedia.dataAccess.UserRepository;
import com.example.socialmedia.entities.Message;

import com.example.socialmedia.entities.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MessageManager implements MessageService {
    private MessageRepository messageRepository;
    private ModelMapperService modelMapperService;
    private MessageRule messageRule;

    private UserRepository userRepository;

    @Override
    public List<GetAllMessageResponse> getAll() {
        List<Message> messages = this.messageRepository.findAll();
        List<GetAllMessageResponse> getAllMessageResponses = messages.stream().map(message -> this.modelMapperService.forResponse().map(message, GetAllMessageResponse.class)).collect(Collectors.toList());
        return getAllMessageResponses;
    }

    @Override
    public List<GetAllMessageResponse> getAllSender(String senderName) {
        this.messageRule.checkIfSenderName(senderName);
        List<Message> messages = this.messageRepository.findBySenderName(senderName);
        List<GetAllMessageResponse> getAllMessageResponses = messages.stream().map(message -> this.modelMapperService.forResponse().map(message, GetAllMessageResponse.class)).collect(Collectors.toList());
        return getAllMessageResponses;
    }

    @Override
    public List<GetAllMessageResponse> getAllReceiver(String receiverName) {
        this.messageRule.checkIfReceiverName(receiverName);
        List<Message> messages = this.messageRepository.findByReceiverName(receiverName);
        List<GetAllMessageResponse> getAllMessageResponses = messages.stream().map(message -> this.modelMapperService.forResponse().map(message, GetAllMessageResponse.class)).collect(Collectors.toList());
        return getAllMessageResponses;
    }

    @Override
    public void add(CreateMessageRequest createMessageRequest) {
        // this.messageRule.checkIfSenderId(createMessageRequest.getSenderId());
        //  this.messageRule.checkIfReceiverId(createMessageRequest.getReceiverId());
        Message message = this.modelMapperService.forRequest().map(createMessageRequest, Message.class);
        this.messageRepository.save(message);
    }

    @Override
    public void delete(int id) {
        // this.messageRule.checkIfId(id);
        this.messageRepository.deleteById(id);
    }



    @Override  // burda Map<string deme sebebimiz username string olduğu için boş bir mapin ömce anahtarı bu ismimiz olacak daha sonra
               // bu anahtarın ilişkili olduğu mesajları listelicek her anahtar için
    public Map<String, List<GetAllMessageResponse>> getMessagesByUser(String userName) {

        // kullanıcıyı veri tabanından cektik sender veya receiver olmasının önemi yok kullanıcı olması yeterli cünkü bu bizim mapimizin anahtarı
        User user = userRepository.findByName(userName);

        // bu metot bize eğer kullanıcı yoksa bunu yerine boş bir map döndürür
        if (user == null) {
            return Collections.emptyMap();
        }

        // Kullanıcının gönderdiği ve aldığı tüm mesajları aldık burası işte anahtarımızın ilişkili olduğu mesajlar listesi
        // İKİ KERE AYNI USER PARAMETRESİNİ GİRME SEBEBİMİZ HEM ALICI OLDUĞU HEM GÖNDERİCİ OLDUĞU İÇİNDİR
        List<Message> sentMessages = messageRepository.findBySenderOrReceiverOrderByDate(user, user);

        // Mesajları gönderilme/alınma tarihine göre sıralama yapıldı-sort metotu karşılaştırıcı bir metot bunu comparator ile yaptı
        //bu kodu yazmasakta çalışır cünkü findBySenderOrReceiverOrderByDate bu kod zaten sıraladı bizim için
      sentMessages.sort(Comparator.comparing(Message::getDate));

        // Kullanıcının iletişimde olduğu diğer kullanıcılarla mesajları gruplayın
        Map<String, List<GetAllMessageResponse>> messagesByUser = new HashMap<>();

        for (Message message : sentMessages) {
            String otherUserName;
            if (message.getSender().equals(user)) {
                otherUserName = message.getReceiver().getName();
            } else {
                otherUserName = message.getSender().getName();
            }
            messagesByUser.computeIfAbsent(otherUserName, k -> new ArrayList<>())
                    .add(modelMapperService.forResponse().map(message, GetAllMessageResponse.class));
        }

        return messagesByUser;
    }
}





