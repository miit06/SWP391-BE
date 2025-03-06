package com.example.demo.Reservation.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "Reservation")
public class Reservation {
    @Id
    private String ID;

    @Column(name = "CustomerID")
    private String CustomerID;

    @Column(name = "Total Price")
    private BigDecimal TotalPrice;

    @Column(name = "Status")
    private String Status;

    @Column(name = "TimeCheckUp")
    private Date TimeCheckUp;
}
