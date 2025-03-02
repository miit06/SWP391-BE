package com.example.demo.Servicelist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicelistRepo extends JpaRepository<Servicelist, String> {
}
