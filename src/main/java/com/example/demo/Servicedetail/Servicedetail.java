package com.example.demo.Servicedetail;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Servicedetail")
@Data
public class Servicedetail {

    @Id
    private String id;

    @Column (name = "Name")
    private String name;

    @Column (name = "Detail")
    private String detail;

    @Column (name = "Quantity")
    private int quantity;

    @Column (name = "Price")
    private String price;

}
