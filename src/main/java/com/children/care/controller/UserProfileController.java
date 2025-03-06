package com.children.care.controller;

import com.children.care.dto.request.UserProfileRequest;
import com.children.care.entity.Account;
import com.children.care.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserProfileController {
    @Autowired
    private UserProfileService userProfileService;

    @PutMapping("/update/{id}")
    Account updateChild(@PathVariable("id") int id, @RequestBody UserProfileRequest request){
        return userProfileService.updateUserProfile(id,request);
    }

}
