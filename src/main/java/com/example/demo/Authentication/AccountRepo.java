package com.example.demo.Authentication;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepo extends JpaRepository<Account,Integer> {
    Account findByUsername(String username);
}
