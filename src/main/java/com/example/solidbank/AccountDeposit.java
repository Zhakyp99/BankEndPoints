package com.example.solidbank;

import jakarta.persistence.Entity;

@Entity
public class AccountDeposit extends Account{
    public AccountDeposit(AccountType accountType, String id, String clientID, double balance) {
        super(accountType, id, clientID, balance, false);
    }

    public AccountDeposit() {

    }
}
