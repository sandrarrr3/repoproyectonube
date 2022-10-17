
package com.G42_Proyecto.G42_Proyecto.Controller;


import com.G42_Proyecto.G42_Proyecto.Service.MessageService;
import com.G42_Proyecto.G42_Proyecto.entities.Message;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Message")
public class MessageController {
    
     @Autowired
    private MessageService messageService;
    
    @GetMapping("/all")
    public List<Message> getAll(){
        return messageService.getAll();
        
    }
    
    
                @GetMapping("{id}")
    public Optional<Message> getClient(@PathVariable("id") int messageId){
        return messageService.getMessage(messageId);       
    }
    
    
    @PostMapping("/save")
    public Message save(@RequestBody Message m){
        return messageService.save(m);
        
    }
    
}

    
    
