package com.example.demo.Servicedetail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServicedetailService {
    @Autowired
    public ServicedetailRepo serviceRepository;

    public List<Servicedetail> getAllServices() {
        return List.of();
    }

    public Servicedetail getServiceById(String id) {
        return serviceRepository.findById(id).get();
    }
}