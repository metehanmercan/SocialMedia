package com.example.socialmedia.dataAccess;

import com.example.socialmedia.entities.Message;
import com.example.socialmedia.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message,Integer> {

    List<Message> findBySenderName(String senderName);
    List<Message> findByReceiverName(String receiverName);

    boolean existsBySenderId(int senderId);
    boolean existsByReceiverId(int receiverId);


    boolean existsById(int id);



///// alttaki metotlar kullacını diğer kişilerle olan mesajlarını liste şeklinde bulmak ve tarihe göre listelemek için kullanıldı
    boolean existsBySenderName(String senderName);
    boolean existsByReceiverName(String receiverName);
    List<Message> findBySenderOrderByDate(User sender);
    List<Message> findByReceiverOrderByDate(User receiver);


    List<Message> findByReceiver(User receiver);

    List<Message> findBySenderOrReceiverOrderByDate(User user, User user1);
}
