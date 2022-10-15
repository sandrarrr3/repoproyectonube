package com.G42_Proyecto.G42_Proyecto.repository;

import com.G42_Proyecto.G42_Proyecto.crudRepository.UserCrudRepository;
import com.G42_Proyecto.G42_Proyecto.entities.User;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
public class UserRepository {
  
    
    @Autowired
    private UserCrudRepository userCrudRepository;
    
    public List<User>getAll(){
        return (List<User>) userCrudRepository.findAll();
    }
    
    public Optional<User>  getUser(int  id){
        return userCrudRepository.findById(id);
        
    }
    
    public User save (User u){
        return userCrudRepository.save(u);
    }
        
        public void delete  (User u){  
        userCrudRepository.delete(u);
    }
    



    
}
