
package com.G42_Proyecto.G42_Proyecto.Service;

import com.G42_Proyecto.G42_Proyecto.entities.Reservation;
import com.G42_Proyecto.G42_Proyecto.repository.ReservationRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {
    
        @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAll() {
        return reservationRepository.getAll();
    }

    public Optional<Reservation> getReservation  (int id) {
        return reservationRepository.getReservation(id);
    }
    
       public Reservation save(Reservation s) {

        if (s.getIdReservation() == null) {
            return reservationRepository.save(s);
        } else {
            Optional<Reservation> e = reservationRepository.getReservation(s.getIdReservation());
            if (e.isPresent()) {
                return e.get();
            } else {
                return reservationRepository.save(s);
            }
        }
    }
       
       
       
       public Reservation update(Reservation s) {
        if (s.getIdReservation()!= null) {
            Optional<Reservation> q = reservationRepository.getReservation(s.getIdReservation());
            if (q.isPresent()) {
                if (s.getStartDate()!= null) {
                    q.get().setStartDate(s.getStartDate());
                }
                if (s.getDevolutionDate()!= null) {
                    q.get().setDevolutionDate(s.getDevolutionDate());
                }
                if (s.getCreated()!= null) {
                    q.get().setCreated(s.getCreated());
                }
                if (s.getStatus() != null) {
                    q.get().setStatus(s.getStatus());
                }

                reservationRepository.save(q.get());
                return q.get();

            } else {
                return s;
            }

        } else {
            return s;
        }
    }
       
       
public boolean delete  (int id){
    boolean flag = false;
    Optional <Reservation>s = reservationRepository.getReservation(id);
    if (s.isPresent()){
        reservationRepository.delete(s.get());
        flag = true;
    }
    return flag;
}
    
    
 
}
