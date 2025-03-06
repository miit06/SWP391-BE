package com.children.care.controller;

import com.children.care.entity.ServiceReservation;
import com.children.care.service.ServiceReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/servicereservation")
public class ServiceReservationController {
    @Autowired
    private ServiceReservationService serviceReservationService;


    @GetMapping
    public ResponseEntity<List<ServiceReservation>> getAllServiceReservation() {
        return ResponseEntity.ok(serviceReservationService.getAllServiceReservations());
    }

    @GetMapping("/{reservationid}")
    public ResponseEntity<List<ServiceReservation>> getReservation(@PathVariable String reservationid) {
        return ResponseEntity.ok(serviceReservationService.findReservationByReservationID(reservationid));
    }

    @PutMapping("/{reservationid}")
    public ResponseEntity<ServiceReservation> updateServiceReservation(@PathVariable String reservationid, @RequestBody String serviceid, @RequestBody ServiceReservation serviceReservation) {
        ServiceReservation updateServiceReservation = serviceReservationService.updateServiceReservation(serviceid, reservationid, serviceReservation);
        return (updateServiceReservation != null) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{reservationid}")
    public ResponseEntity<Void> deleteServiceReservation(@PathVariable String reservationid, @RequestBody String serviceid){
        return serviceReservationService.deleteServiceReservation(serviceid, reservationid) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
