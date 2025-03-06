package com.example.demo.Servicedetail;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServicedetailController {
    private final ServicedetailService serviceService;

    public ServicedetailController(ServicedetailService serviceService) {
        this.serviceService = serviceService;
    }

    @GetMapping("/servicedetail")
    public Servicedetail getServiceDetail(@PathVariable String id) {
      Servicedetail servicedetail = serviceService.getServiceById(id);
    return servicedetail;
    }
}