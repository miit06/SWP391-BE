package com.example.demo.Servicelist;

import jakarta.persistence.*;
@Entity
public class Servicelist {
    @Id
    private String id;

    @Column (name = "Name")
    private String name;

    @Column (name = "Detail")
    private String detail;

    @Column (name = "Quantity")
    private int quantity;

    @Column (name = "Price")
    private String Price;
}
