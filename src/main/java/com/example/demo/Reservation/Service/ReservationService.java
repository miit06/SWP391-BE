package com.example.demo.Reservation.Service;

import com.example.demo.Reservation.DTO.request.ReservationRequest;
import com.example.demo.Reservation.Entities.Reservation;
import com.example.demo.Reservation.Repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.smartcardio.Card;
import java.util.List;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getReservations(){return reservationRepository.findAll();}

    public Reservation getReservationByID(String id){
        return reservationRepository.findById(id).get();
    }

    public Reservation addReservation(ReservationRequest reservationRequest){
        Reservation reservation = new Reservation();
        reservation.setCustomerID(reservationRequest.getCustomerID());
        reservation.setStatus(reservationRequest.getStatus());
        reservation.setTotalPrice(reservationRequest.getTotalPrice());
        reservation.setTimeCheckUp(reservationRequest.getTimeCheckUp());
        return reservationRepository.save(reservation);
    }

    public Reservation updateReservationManager(String id, ReservationRequest reservationRequest){
        Reservation reservation = getReservationByID(id);
        reservation.setStatus(reservationRequest.getStatus());
        return  reservationRepository.save(reservation);
    }

    public Reservation updateReservationCustomer(String id, ReservationRequest reservationRequest){
        Reservation reservation = getReservationByID(id);
        reservation.setTotalPrice(reservationRequest.getTotalPrice());
        reservation.setTimeCheckUp(reservationRequest.getTimeCheckUp());
        return  reservationRepository.save(reservation);
    }

    public void deleteReservationById(String id){
        reservationRepository.deleteById(id);
    }
}
