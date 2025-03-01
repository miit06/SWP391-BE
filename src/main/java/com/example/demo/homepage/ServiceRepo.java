package com.example.demo.homepage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface ServiceRepo extends JpaRepository<Service, String> {}
