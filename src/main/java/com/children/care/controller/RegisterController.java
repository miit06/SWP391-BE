package com.children.care.controller;

import com.children.care.dto.request.AuthRequest;
import com.children.care.entity.Account;
import com.children.care.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {
    @Autowired
    private RegisterService registerService;

    @PostMapping("/register")
    Account register(@RequestBody AuthRequest request){
        return registerService.register(request);
    }
}
