package com.children.care.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Account")
public class Account{
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

    public Account() {
    }

    public Account(int id, String username, String userpass, String role, String firstname, String lastname, int age, String email, String phoneNumber, String address) {
        this.id = id;
        this.username = username;
        this.userpass = userpass;
        this.role = role;
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpass() {
        return userpass;
    }

    public void setUserpass(String userpass) {
        this.userpass = userpass;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
