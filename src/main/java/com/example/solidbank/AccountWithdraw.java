package com.example.solidbank;

import jakarta.persistence.Entity;

@Entity
public class AccountWithdraw extends Account{
    public AccountWithdraw(AccountType accountType, String id, String clientID, double balance){
        super(accountType, id , clientID , balance, true);
    }

    public AccountWithdraw() {

    }
}
