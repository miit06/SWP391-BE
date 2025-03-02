package com.example.demo.Servicelist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/servicelist")
@CrossOrigin(origins = "http://localhost:4200")
public class ServicelistController {

    @Autowired
    private ServicelistRepo serviceRepository;

    @GetMapping("/contacts")
    public Map<String, String> getContacts() {
        Map<String, String> contacts = new HashMap<>();
        contacts.put("email", "contact@example.com");
        contacts.put("phone", "+123456789");
        contacts.put("address", "123 Main Street, City");
        return contacts;
    }
}