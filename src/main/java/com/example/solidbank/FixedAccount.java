package com.example.solidbank;

import jakarta.persistence.Entity;

@Entity
public class FixedAccount extends AccountDeposit{

    public FixedAccount(AccountType accountType, String id, String clientID, double balance) {
        super(accountType, id, clientID, balance);
    }

    public FixedAccount() {

    }
}
