package com.example.solidbank;

import jakarta.persistence.Entity;

@Entity
public class CheckingAccount extends AccountWithdraw{

    public CheckingAccount(AccountType accountType, String id, String clientID, double balance) {
        super(accountType, id, clientID, balance);
    }

    public CheckingAccount() {

    }
}
