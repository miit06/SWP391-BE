package com.example.demo.Reservation;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "ReservationService")
public class ServiceReservation {
    @Id
    @Column(name = "ReservationID")
    private String ReservationID;

    @Column(name = "ServiceID")
    private String ServiceID;

    @Column(name = "Quantity")
    private int Quantity;

    @Column(name = "NoP")
    private Integer NoP;

    @Column(name = "Cost")
    private BigDecimal Cost;

}
