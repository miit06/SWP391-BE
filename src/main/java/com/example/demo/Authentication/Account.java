package com.example.demo.Authentication;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "Account")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(name = "Username")
    String username;
    @Column(name = "UserPass")
    String userpass;
    @Column(name = "Role")
    String role;
    @Column(name = "FirstName")
    String firstname;
    @Column(name = "LastName")
    String lastname;
    @Column(name = "Age")
    int age;
    @Column(name = "Email")
    String email;
    @Column(name = "PhoneNum")
    String phoneNumber;
    @Column(name = "Address")
    String address;
}
