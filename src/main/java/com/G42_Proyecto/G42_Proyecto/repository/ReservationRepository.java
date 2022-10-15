package com.G42_Proyecto.G42_Proyecto.repository;

import com.G42_Proyecto.G42_Proyecto.crudRepository.ReservationCrudRepository;
import com.G42_Proyecto.G42_Proyecto.entities.Reservation;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReservationRepository {

    @Autowired
    private ReservationCrudRepository reservationCrudRepository;

    public List<Reservation> getAll() {
        return (List<Reservation>) reservationCrudRepository.findAll();
    }

    public Optional<Reservation> getReservation(int id) {
        return reservationCrudRepository.findById(id);

    }

    public Reservation save(Reservation r) {
        return reservationCrudRepository.save(r);
    }

    public void delete(Reservation r) {
        reservationCrudRepository.delete(r);
    }

}
