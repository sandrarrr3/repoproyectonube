package com.G42_Proyecto.G42_Proyecto.Service;

import com.G42_Proyecto.G42_Proyecto.entities.User;
import com.G42_Proyecto.G42_Proyecto.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAll() {
        return userRepository.getAll();
    }

    public Optional<User> getUser(int id) {
        return userRepository.getUser(id);
    }

    public User save(User u) {
        if (u.getId() == null) {
            return userRepository.save(u);
        } else {
            Optional<User> e = userRepository.getUser(u.getId());
            if (e.isPresent()) {
                return e.get();
            } else {
                return userRepository.save(u);
            }
        }
    }

    public User update(User u) {
        if (u.getId() != null) {
            Optional<User>q = userRepository.getUser(u.getId());
            if (q.isPresent()){
                if(u.getName() !=null){
                    q.get().setName(u.getName());
                }
                if(u.getEmail()!=null){
                    q.get().setEmail(u.getEmail());
                }
                if(u.getPassword()!=null){
                    q.get().setPassword(u.getPassword());
                }
                userRepository.save(q.get());
                return q.get();
            }else{
                return u;
            }
        }else{
            return u;
        }
    }
      
    
    public boolean deleteUser(int id) {
        Boolean d = getUser(id).map(reservation -> {
            userRepository.delete(reservation);
            return true;
        }).orElse(false);
        return d;
    }
    
}
 
      