package com.bichpormak.service;


import com.bichpormak.User;
import com.bichpormak.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AuthServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private AuthService authService;

    private User user;

    @BeforeEach
    public void setUp() {
        user = new User("abobus", "123");
    }

    @Test
    @DisplayName("Authenticate registered user with correct data")
    public void givenRegisteredUser_whenCheckAuthUser_thenAuthenticate() {

        when(userRepository.findUserByUsername(user.getUsername())).thenReturn(user);

        assertTrue(authService.authenticateUser(user.getUsername(), user.getPassword()));

        verify(userRepository).findUserByUsername(user.getUsername());

    }

    @Test
    @DisplayName("User authorization with incorrect password does not get authenticated")
    public void givenUserWithIncorrectPassword_whenCheckAuthUser_thenAuthenticationDenied() {

        when(userRepository.findUserByUsername(user.getUsername())).thenReturn(user);

        assertFalse(authService.authenticateUser(user.getUsername(), "abobus"));

        verify(userRepository).findUserByUsername(user.getUsername());

    }

    @Test
    @DisplayName("Not registered user does not get authenticated")
    public void givenNotRegisteredUser_whenCheckAuthUser_thenAuthenticationDenied() {

        when(userRepository.findUserByUsername(user.getUsername())).thenReturn(null);

        assertFalse(authService.authenticateUser(user.getUsername(), user.getPassword()));

        verify(userRepository).findUserByUsername(user.getUsername());

    }


}
