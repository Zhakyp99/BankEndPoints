package com.example.solidbank;

import org.springframework.stereotype.Component;

@Component
public class TransactionDepositCLI {
    TransactionDeposit transactionDeposit;
    WithdrawDepositOperationCLIUI withdrawDepositOperationCLIUI;
    AccountListingService accountListing;

    public TransactionDepositCLI(TransactionDeposit transactionDeposit,
                                 WithdrawDepositOperationCLIUI withdrawDepositOperationCLIUI,
                                 AccountListingService accountListing) {
        this.transactionDeposit = transactionDeposit;
        this.withdrawDepositOperationCLIUI = withdrawDepositOperationCLIUI;
        this.accountListing = accountListing;
    }

    public void depositMoney(String clientID) {
        double amount = withdrawDepositOperationCLIUI.requestClientAmount();
        String accountID = withdrawDepositOperationCLIUI.requestClientAccountNumber();
        Account account = accountListing.getClientAccount(clientID, accountID);
        if (account == null) {
            System.out.println("Error, you entered wrong account number");
            return;
        }
        transactionDeposit.execute(account, amount);
    }
}
