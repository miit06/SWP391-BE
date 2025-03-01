package com.example.demo.homepage;

import org.springframework.data.jpa.repository.JpaRepository;


public interface PostRepo extends JpaRepository<Post, String> {

}