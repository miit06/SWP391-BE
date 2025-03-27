package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "account")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @Column(name = "user_pass", nullable = false)
    private String userpass; // Mật khẩu đã mã hóa

    @Column(name = "role", nullable = false)
    private String role;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "age")
    private int age;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "phone_num", unique = true, nullable = false)
    private String phoneNumber;

    @Column(name = "address")
    private String address;

    @Column(name = "status", nullable = false)
    private String status; // ACTIVE / INACTIVE

    @Column(name = "jwt_token", columnDefinition = "TEXT")
    private String jwtToken;

    @Column(name = "reset_token")
    private String resetToken; // Token đặt lại mật khẩu

    @Column(name = "email_verified", nullable = false)
    private boolean emailVerified = false; // Kiểm tra xác thực email

    // Constructor tùy chỉnh nếu cần
    public Account(String username, String userpass, String email) {
        this.username = username;
        this.userpass = userpass;
        this.email = email;
        this.status = "ACTIVE";
        this.emailVerified = false;
    }
}
