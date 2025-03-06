package com.children.care.controller;

import com.children.care.entity.Account;
import com.children.care.service.AccountService;
import com.children.care.config.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final AccountService accountService;
    private final JwtUtil jwtUtil;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager, AccountService accountService, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.accountService = accountService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/auth/register")
    public ResponseEntity<?> registerUser(@RequestBody Account account) {
        if (accountService.findByUsername(account.getUsername()).isPresent()) {
            return ResponseEntity.badRequest().body("Username is already taken");
        }
        accountService.saveAccount(account);
        return ResponseEntity.ok("Đăng kí thành công");
    }

    @PostMapping("/auth/login")
    public ResponseEntity<?> loginUser(@RequestBody Account account) {
        try {
            // Authenticate the user
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(account.getUsername(), account.getUserpass()));

            // Retrieve the authenticated user and generate JWT
            Account authenticatedUser = accountService.findByUsername(account.getUsername()).orElseThrow(() -> new AuthenticationException("Invalid credentials") {});
            String jwt = jwtUtil.generateToken(authenticatedUser.getUsername());

            return ResponseEntity.ok(jwt);
        } catch (AuthenticationException e) {
            return ResponseEntity.status(401).body("Invalid username or password");
        }
    }
}
