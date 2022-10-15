package com.G42_Proyecto.G42_Proyecto.repository;

import com.G42_Proyecto.G42_Proyecto.crudRepository.ClientCrudRepository;
import com.G42_Proyecto.G42_Proyecto.entities.Client;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ClientRepository {

    @Autowired
    private ClientCrudRepository clientCrudRepository;

    public List<Client> getAll(){
        return  (List<Client>) clientCrudRepository.findAll();
    }
    
    public Optional<Client> getClient (int id) {
        return clientCrudRepository.findById(id);
        
    }
    
    public Client save (Client t){
        return clientCrudRepository.save(t);
        
    }
    
   
    public void delete (Client t){
        clientCrudRepository.delete(t);
    }
    
}
