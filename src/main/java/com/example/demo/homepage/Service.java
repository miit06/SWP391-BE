package com.example.demo.homepage;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Servicelist")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Service {
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
