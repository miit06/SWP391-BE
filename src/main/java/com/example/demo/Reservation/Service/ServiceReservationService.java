package com.example.demo.Reservation.Service;

import com.example.demo.Reservation.Entities.Reservation;
import com.example.demo.Reservation.Entities.ServiceReservation;
import com.example.demo.Reservation.Repository.ReservationRepository;
import com.example.demo.Reservation.Repository.ServiceReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceReservationService {
    @Autowired
    private ServiceReservationRepository serviceReservationRepository;

    public List<ServiceReservation> getServiceReservations(){return serviceReservationRepository.findAll();}

    public ServiceReservation getServiceReservationByID(String id){
        return serviceReservationRepository.findById(id).get();
    }



}
