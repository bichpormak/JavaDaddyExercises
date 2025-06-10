package com.bichpormak.service;

import com.bichpormak.model.Account;
import com.bichpormak.repository.AccountRepository;

public class AccountService {

    private AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public boolean withdraw(String accountId, double amount) {
        Account account = accountRepository.findAccountById(accountId);
        if (account != null && account.getBalance() >= amount) {
            account.withdraw(amount);
            accountRepository.updateAccount(account);
            return true;
        }
        return false;
    }

}