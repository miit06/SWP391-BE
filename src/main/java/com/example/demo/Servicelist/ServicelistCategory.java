package com.example.demo.Servicelist;

import jakarta.persistence.*;

@Entity
@Table(name = "Category")
public class ServicelistCategory {
    @Id
    private String id;

    @Column(name = "Title")
    private String title;
}

