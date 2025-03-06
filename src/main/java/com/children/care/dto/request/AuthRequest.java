package com.children.care.dto.request;

import jakarta.persistence.Column;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthRequest {
    String username;
    String userpass;
    String role;
    String firstname;
    String lastname;
    int age;
    String email;
    String phoneNumber;
}
