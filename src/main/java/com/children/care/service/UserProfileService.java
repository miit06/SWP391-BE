package com.children.care.service;

import com.children.care.dto.request.AuthRequest;
import com.children.care.dto.request.UserProfileRequest;
import com.children.care.entity.Account;
import com.children.care.repository.AccountRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserProfileService {
    @Autowired
    private AccountRepo accountRepo;

    public Account getAccountByID(int id){
        return accountRepo.findById(id).get();
    }
    public Account updateUserProfile(int id, UserProfileRequest request){
        Account account = getAccountByID(id);
        account.setFirstname(request.getFirstname());
        account.setLastname(request.getLastname());
        account.setUsername(request.getUsername());
        account.setEmail(request.getEmail());
        account.setPhoneNumber(request.getPhoneNumber());
        account.setAddress(request.getAddress());
        return accountRepo.save(account);
    }
    public Account register(AuthRequest request){
        Account account = new Account();
        account.setFirstname(request.getFirstname());
        account.setLastname(request.getLastname());
        account.setUsername(request.getUsername());
        account.setEmail(request.getEmail());
        account.setPhoneNumber(request.getPhoneNumber());
        account.setUserpass(request.getUserpass());

        return accountRepo.save(account);
    }

    public List<Account> getAllAccount(){
        return accountRepo.findAll();
    }

}
