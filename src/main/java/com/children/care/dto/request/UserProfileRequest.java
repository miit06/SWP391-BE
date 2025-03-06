package com.children.care.dto.request;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserProfileRequest {
    String username;
    String firstname;
    String lastname;
    int age;
    String email;
    String phoneNumber;
    String address;
}
