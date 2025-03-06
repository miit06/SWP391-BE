package com.children.care.repository;

import com.children.care.entity.ServiceReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceReservationRepository extends JpaRepository<ServiceReservation, String> {
    ServiceReservation findByServiceIdAndReservationId(String serviceID, String reservationID);
    List<ServiceReservation> findByReservationId(String reservationID);
}
