package com.G42_Proyecto.G42_Proyecto.crudRepository;

import com.G42_Proyecto.G42_Proyecto.entities.Reservation;
import org.springframework.data.repository.CrudRepository;


public interface ReservationCrudRepository extends CrudRepository <Reservation, Integer> {
    
}
