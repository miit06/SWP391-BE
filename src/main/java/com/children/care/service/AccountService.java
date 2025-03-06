package com.children.care.service;

import java.util.List;
import java.util.Optional;

import com.children.care.entity.Account;
import com.children.care.repository.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;



@Service
public class AccountService implements UserDetailsService{
    private final AccountRepo accountRepo;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AccountService(AccountRepo accountRepo) {
        this.accountRepo = accountRepo;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public Account saveAccount(Account account) {
        account.setUserpass(passwordEncoder.encode(account.getUserpass()));
        return accountRepo.save(account);
    }

    public Optional<Account> findByUsername(String username) {
        return Optional.ofNullable(accountRepo.findByUsername(username));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account user = accountRepo.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return org.springframework.security.core.userdetails.User
                .withUsername(user.getUsername())
                .password(user.getUserpass())
                .authorities("USER")
                .build();
    }

    public List<Account> findAllUsers() {
        return accountRepo.findAll();
    }
}
