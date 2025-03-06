package com.children.care.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Reservation")
public class Reservation {

    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "CustomerID")
    private String customerId;

    @Column(name = "TotalPrice")
    private BigDecimal totalPrice;

    @Column(name = "Status")
    private String status;

    @Column(name = "TimeCheckUp")
    private Date timeCheckUp;

}