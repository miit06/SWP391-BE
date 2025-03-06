package com.children.care.controller;

import com.children.care.service.ServiceReservationService;
import com.example.demo.Reservation.ServiceReservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/servicereservations")
public class ServiceReservationController {
    @Autowired
    private ServiceReservationService serviceReservationService;

    @GetMapping
    public ResponseEntity<List<ServiceReservation>> getAllReservation() {
        return ResponseEntity.ok(serviceReservationService.getAllServiceReservations());
    }


}
