
package com.G42_Proyecto.G42_Proyecto.Controller;

import com.G42_Proyecto.G42_Proyecto.Service.UserService;
import com.G42_Proyecto.G42_Proyecto.entities.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/User")
public class UserController {
    
    
   @Autowired
    private UserService userService;
    
    @GetMapping("/all")
    public List<User> getAll(){
        return userService.getAll();
        
    }
    
    @PostMapping("/save")
    public User save(@RequestBody User u){
        return userService.save(u);
        
    }

    
}
