package com.G42_Proyecto.G42_Proyecto.Controller;

import com.G42_Proyecto.G42_Proyecto.Service.ClientService;
import com.G42_Proyecto.G42_Proyecto.entities.Client;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/Client")
public class ClientController {
    
     @Autowired
    private ClientService clientService;
    
    @GetMapping("/all")
    public List<Client> getAll(){
        return clientService.getAll();
        
    }
    
    @PostMapping("/save")
    public Client save(@RequestBody Client c){
        return clientService.save(c);
        
    }
    
}
