package com.children.care.repository;

import com.children.care.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepo extends JpaRepository<Account,Integer> {
    Account findByUsername(String username);
}
