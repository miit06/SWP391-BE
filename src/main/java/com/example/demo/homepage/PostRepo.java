package com.example.demo.homepage;

import com.example.demo.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PostRepo extends JpaRepository<Post, String> {

}