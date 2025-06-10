package com.bichpormak.service;


import com.bichpormak.model.Account;
import com.bichpormak.repository.AccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
public class AccountServiceTest {

    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private AccountService accountService;

    private Account account;

    @BeforeEach
    public void setUp() {
        account = new Account("abobus", 5000);
    }


    @Test
    @DisplayName("Successful withdraw money")
    public void givenAccount_whenWithdrawMoney_thenSuccessfulOperation() {

        when(accountRepository.findAccountById(account.getAccountId())).thenReturn(account);

        int amountLessThanUserBalance = 3000;

        assertTrue(accountService.withdraw(account.getAccountId(), amountLessThanUserBalance));
        assertEquals(account.getBalance(), 2000);

        verify(accountRepository).updateAccount(account);

    }

    @Test
    @DisplayName("There is not enough money in the account to withdraw")
    public void givenAccountWithNotEnoughMoney_whenWithdrawMoney_thenUnsuccessfulOperation() {

        when(accountRepository.findAccountById(account.getAccountId())).thenReturn(account);

        int amountMoreThanUserBalance = 6000;

        assertFalse(accountService.withdraw(account.getAccountId(), amountMoreThanUserBalance));

        verify(accountRepository, times(0)).updateAccount(account);

    }

    @Test
    @DisplayName("Not found account in database")
    public void givenNotFountAccount_whenWithdrawMoney_thenUnsuccessfulOperation() {

        when(accountRepository.findAccountById(account.getAccountId())).thenReturn(null);

        assertFalse(accountService.withdraw(account.getAccountId(), account.getBalance()));

        verify(accountRepository, times(0)).updateAccount(account);

    }

}
