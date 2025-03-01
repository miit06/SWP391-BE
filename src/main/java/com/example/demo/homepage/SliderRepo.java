package com.example.demo.homepage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface SliderRepo extends JpaRepository<Slider, String> {}