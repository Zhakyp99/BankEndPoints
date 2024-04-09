package com.example.solidbank;

import org.springframework.stereotype.Component;

@Component
public class TransactionWithdrawCLI {
    private TransactionWithdraw transactionWithdraw;
    private WithdrawDepositOperationCLIUI withdrawDepositOperationCLIUI;
    private AccountListingService accountListing;

    public TransactionWithdrawCLI(TransactionWithdraw transactionWithdraw,
                                  WithdrawDepositOperationCLIUI withdrawDepositOperationCLIUI,
                                  AccountListingService accountListing) {
        this.transactionWithdraw = transactionWithdraw;
        this.withdrawDepositOperationCLIUI = withdrawDepositOperationCLIUI;
        this.accountListing = accountListing;
    }

    public void withdrawMoney(String clientID) {
        double amount = withdrawDepositOperationCLIUI.requestClientAmount();
        String accountID = withdrawDepositOperationCLIUI.requestClientAccountNumber();
        AccountWithdraw account = accountListing.getClientWithdrawAccount(clientID, accountID);
        if (account == null) {
            System.out.println("Error, you there was not Withdraw Account found by this ID");
            return;
        }
        transactionWithdraw.execute(account, amount);
    }
}
