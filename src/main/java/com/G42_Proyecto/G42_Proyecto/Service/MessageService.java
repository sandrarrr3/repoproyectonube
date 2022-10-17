package com.G42_Proyecto.G42_Proyecto.Service;

import com.G42_Proyecto.G42_Proyecto.entities.Message;
import com.G42_Proyecto.G42_Proyecto.repository.MessageRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAll() {
        return messageRepository.getAll();
    }

    public Optional<Message> getMessage(int id) {
        return messageRepository.getMessage(id);
    }

    public Message save(Message m) {
        if (m.getIdMessage() == null) {
            return messageRepository.save(m);
        } else {
            Optional<Message> e = messageRepository.getMessage(m.getIdMessage());
            if (e.isPresent()) {
                return e.get();
            } else {
                return messageRepository.save(m);
            }
        }

    }

    public Message update(Message m) {
        if (m.getIdMessage() != null) {
            Optional<Message> q = messageRepository.getMessage(m.getIdMessage());
            if (q.isPresent()) {
                if (m.getMessageText() != null) {
                    q.get().setMessageText(m.getMessageText());
                }
                messageRepository.save(q.get());
                return q.get();
            } else {
                return m;
            }
        } else {
            return m;
        }

    }

    public boolean deleteMessage(int id) {
        Boolean d = getMessage(id).map(client -> {
            messageRepository.delete(client);
            return true;
        }).orElse(false);
        return d;
    }
    
}
        
