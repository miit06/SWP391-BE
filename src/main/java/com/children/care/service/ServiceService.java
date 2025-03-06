package com.children.care.service;

import com.children.care.entity.Servicedetail;
import com.children.care.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServiceService {
    @Autowired
    public ServiceRepository serviceRepository;

    public List<Servicedetail> getAllServices() {
        return List.of();
    }

    public Servicedetail getServiceById(String id) {
        return serviceRepository.findById(id).get();
    }
}