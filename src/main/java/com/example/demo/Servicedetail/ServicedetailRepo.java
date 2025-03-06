package com.example.demo.Servicedetail;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicedetailRepo extends JpaRepository<Servicedetail, String> {
}
