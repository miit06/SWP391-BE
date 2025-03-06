package com.children.care.service;

import com.children.care.entity.Reservation;
import com.children.care.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAllReservations(){return reservationRepository.findAll();}

    public Reservation getReservationByID(String id) {
        return reservationRepository.findById(id).get();
    }

    public Reservation createReservation(Reservation reservation){
        return reservationRepository.save(reservation);
    }

    public Reservation updateReservation(String id, Reservation updatedReservation){
        Reservation reservation = getReservationByID(id);
        if (reservation != null){
            reservation.setCustomerId(updatedReservation.getCustomerId());
            reservation.setTotalPrice(updatedReservation.getTotalPrice());
            reservation.setStatus(updatedReservation.getStatus());
            reservation.setTimeCheckUp(updatedReservation.getTimeCheckUp());
            return reservationRepository.save(reservation);
        }
        return null;
    }

    public boolean deleteReservation(String id) {
        if (reservationRepository.existsById(id)) {
            reservationRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
