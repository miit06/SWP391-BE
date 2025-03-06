package com.example.demo.homepage;

import com.children.care.entity.Service;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ServiceRepo extends JpaRepository<Service, String> {}
