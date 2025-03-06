package com.children.care.repository;

import com.example.demo.Reservation.ServiceReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceReservationRepository extends JpaRepository<ServiceReservation, String> {
    ServiceReservation findByServiceIdAndReservationId(String serviceID, String reservationID);
}
