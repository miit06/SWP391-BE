package com.example.demo.Servicelist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/servicelist")
public class ServicelistController {
    @Autowired
    private ServicelistService serviceService;
    private ServicelistRepo servicelistRepo;

    public List<Servicelist> getServicelist() {
        return servicelistRepo.findAll();
    }
}

