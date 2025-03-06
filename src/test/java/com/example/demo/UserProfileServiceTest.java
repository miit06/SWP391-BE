package com.example.demo;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.children.care.dto.request.AuthRequest;
import com.children.care.dto.request.UserProfileRequest;
import com.children.care.entity.Account;
import com.children.care.repository.AccountRepo;
import com.children.care.service.UserProfileService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

public class UserProfileServiceTest {

    @InjectMocks
    private UserProfileService userProfileService;

    @Mock
    private AccountRepo accountRepo;

    private Account account;
    private UserProfileRequest userProfileRequest;
    private AuthRequest authRequest;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        account = new Account();
        account.setId(1);
        account.setFirstname("John");
        account.setLastname("Doe");
        account.setUsername("johndoe");
        account.setEmail("john@gmail.com");
        account.setPhoneNumber("1234567890");
        account.setAddress("123 Main St");

        userProfileRequest = new UserProfileRequest();
        userProfileRequest.setFirstname("Jane");
        userProfileRequest.setLastname("Smith");
        userProfileRequest.setUsername("janesmith");
        userProfileRequest.setEmail("jane@gmail.com");
        userProfileRequest.setPhoneNumber("0987654321");
        userProfileRequest.setAddress("456 Elm St");

        authRequest = new AuthRequest();
        authRequest.setFirstname("Alice");
        authRequest.setLastname("Johnson");
        authRequest.setUsername("alicejohnson");
        authRequest.setEmail("alice@gmail.com");
        authRequest.setPhoneNumber("1112223333");
        authRequest.setUserpass("password123");
    }

    @Test
    public void testUpdateUserProfile() {
        when(accountRepo.findById(1)).thenReturn(Optional.of(account));
        when(accountRepo.save(any(Account.class))).thenReturn(account);

        Account updatedAccount = userProfileService.updateUserProfile(1, userProfileRequest);

        assertEquals("Jane", updatedAccount.getFirstname());
        assertEquals("Smith", updatedAccount.getLastname());
        assertEquals("janesmith", updatedAccount.getUsername());
        assertEquals("jane@gmail.com", updatedAccount.getEmail());
        assertEquals("0987654321", updatedAccount.getPhoneNumber());
        assertEquals("456 Elm St", updatedAccount.getAddress());

        verify(accountRepo).findById(1);
        verify(accountRepo).save(account);
    }

    @Test
    public void testRegister() {
        when(accountRepo.save(any(Account.class))).thenReturn(account);

        Account registeredAccount = userProfileService.register(authRequest);

        assertEquals("Alice", registeredAccount.getFirstname());
        assertEquals("Johnson", registeredAccount.getLastname());
        assertEquals("alicejohnson", registeredAccount.getUsername());
        assertEquals("alice@gmail.com", registeredAccount.getEmail());
        assertEquals("1112223333", registeredAccount.getPhoneNumber());
        assertEquals("password123", registeredAccount.getUserpass());

        verify(accountRepo).save(any(Account.class));
    }
}
