package com.example.demo.homepage;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Service")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Service {
    @Id

    private String id;

    @Column (name = "ServiceName")
    private String serviceName;

    @Column (name = "ServiceDetail")
    private String serviceDetail;

    @Column (name = "ServiceQuantity")
    private int serviceQuantity;

    @Column (name = "ServicePrice")
    private int servicePrice;
}
