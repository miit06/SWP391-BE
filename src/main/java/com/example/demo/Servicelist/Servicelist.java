package com.example.demo.Servicelist;

import jakarta.persistence.*;
import jdk.jfr.Category;
import lombok.*;

@Entity
@Table(name = "Servicelist")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Servicelist {

    @Id
    private String id;

    @Column (name = "Detail")
    private String detail;

    @Column (name = "Name")
    private String name;

    @Column (name = "Price")
    private String price;

    @Column (name = "Quantity")
    private int quantity;

}
