package com.children.care.controller;


import com.children.care.entity.Servicedetail;
import com.children.care.service.ServiceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServicedetailController {
    private final ServiceService serviceService;

    public ServicedetailController(ServiceService serviceService) {
        this.serviceService = serviceService;
    }

    @GetMapping("/servicedetail")
    public Servicedetail getServiceDetail(@PathVariable String id) {
      Servicedetail servicedetail = serviceService.getServiceById(id);
    return servicedetail;
    }
}