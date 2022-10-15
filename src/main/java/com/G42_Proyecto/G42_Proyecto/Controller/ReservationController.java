
package com.G42_Proyecto.G42_Proyecto.Controller;

import com.G42_Proyecto.G42_Proyecto.Service.ReservationService;
import com.G42_Proyecto.G42_Proyecto.entities.Reservation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/reservation")        
public class ReservationController {
    
    
        @Autowired
    private ReservationService reservationService;
    
    @GetMapping("/all")
    public List<Reservation> getAll(){
        return reservationService.getAll();
        
    }
    
    @PostMapping("/save")
    public Reservation save(@RequestBody Reservation r){
        return reservationService.save(r);
        
    }
    
}

   