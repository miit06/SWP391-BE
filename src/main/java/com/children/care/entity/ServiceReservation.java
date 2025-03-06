package com.children.care.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ReservationService")
public class ServiceReservation {

    @Column(name = "ReservationID")
    private String reservationID;

    @Column(name = "ServiceID")
    private String serviceID;

    @Column(name = "Quantity")
    private int quantity;

    @Column(name = "NoP")
    private Integer NoP;

    @Column(name = "Cost")
    private BigDecimal cost;

}
