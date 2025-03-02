package com.example.demo.Reservation.Repository;

import com.example.demo.Reservation.Entities.ServiceReservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceReservationRepository extends JpaRepository<ServiceReservation, String> {
}
