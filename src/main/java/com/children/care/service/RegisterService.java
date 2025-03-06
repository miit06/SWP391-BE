package com.children.care.service;

import com.children.care.dto.request.AuthRequest;
import com.children.care.entity.Account;
import com.children.care.repository.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {
    @Autowired
    private AccountRepo accountRepo;

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
}
