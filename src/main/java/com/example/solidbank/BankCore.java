package com.example.solidbank;


import org.springframework.stereotype.Component;

@Component
public class BankCore {
    private static long id = 1;
    private long lastAccountNumber = 1;
    private AccountCreationService accountCreation;

    public BankCore(AccountCreationService accountCreation) {
        this.accountCreation = accountCreation;
    }

    public void createNewAccount(AccountType accountType, String clientID){
        accountCreation.create(accountType, id, clientID, lastAccountNumber);
        incrementLastAccountNumber();
        System.out.println("Bank account created");
    }

    private void incrementLastAccountNumber() {
        lastAccountNumber++;
    }
}
