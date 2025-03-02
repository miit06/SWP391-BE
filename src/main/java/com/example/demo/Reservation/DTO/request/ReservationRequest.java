package com.example.demo.Reservation.DTO.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReservationRequest {
    private String CustomerID;
    private BigDecimal TotalPrice;
    private String Status;
    private Date TimeCheckUp;
}
