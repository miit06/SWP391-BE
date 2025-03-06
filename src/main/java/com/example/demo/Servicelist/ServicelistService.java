package com.example.demo.Servicelist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicelistService {

    @Autowired
    private ServicelistRepo serviceRepository;

    public List<Servicelist> getAllServicelist() {
        return serviceRepository.findAll();
    }

    public Servicelist getServiceById(String id) {
        return serviceRepository.findById(id).get();
    }

    public Servicelist saveService(Servicelist service) {
        return serviceRepository.save(service);
    }

    public void deleteService(String id) {
        serviceRepository.deleteById(id);
    }

}

