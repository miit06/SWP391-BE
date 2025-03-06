package com.children.care.service;

import com.children.care.entity.ServiceReservation;
import com.children.care.repository.ServiceReservationRepository;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ServiceReservationService {
    @Autowired
    private ServiceReservationRepository serviceReservationRepository;

    public List<ServiceReservation> getAllServiceReservations(){
        return serviceReservationRepository.findAll();
    }

    public ServiceReservation getReservation(String ServiceID, String ReservationID) {
        return serviceReservationRepository.findByServiceIdAndReservationId(ServiceID,ReservationID);
    }

    public ServiceReservation createServiceReservation(ServiceReservation serviceReservation){
        return serviceReservationRepository.save(serviceReservation);
    }

    public List<ServiceReservation> findReservationByReservationID(String ReservationID){
        return serviceReservationRepository.findByReservationId(ReservationID);
    }

    public ServiceReservation updateServiceReservation(String ServiceID, String ReservationID, ServiceReservation serviceReservation) {
        ServiceReservation updatedServiceReservation = serviceReservationRepository.findByServiceIdAndReservationId(ServiceID, ReservationID);
        if (updatedServiceReservation != null) {
            updatedServiceReservation.setQuantity(serviceReservation.getQuantity());
            updatedServiceReservation.setNoP(serviceReservation.getNoP());
            updatedServiceReservation.setCost(serviceReservation.getCost());
            return serviceReservationRepository.save(updatedServiceReservation);
        }
        return null;
    }

    public boolean deleteServiceReservation(String ServiceID, String ReservationID){
        ServiceReservation serviceReservation = serviceReservationRepository.findByServiceIdAndReservationId(ServiceID, ReservationID);
        if(serviceReservation != null){
            serviceReservationRepository.delete(serviceReservation);
            return true;
        }
        return false;
    }
}
