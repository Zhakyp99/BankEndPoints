package com.example.solidbank;

import org.springframework.stereotype.Component;

@Component
public class TransactionDeposit {
    private AccountDepositService accountDepositService;
    private TransactionDAO transactionDAO;

    public TransactionDeposit(AccountDepositService accountDepositService, TransactionDAO transactionDAO) {
        this.accountDepositService = accountDepositService;
        this.transactionDAO = transactionDAO;
    }

    public void execute(Account account, double amount) {
        accountDepositService.deposit(amount, account);

        String transactionDescription = String.format("%.2f$ transferred to %s account", amount, account.getId());
        Transaction transaction = new Transaction();
        transaction.setId("001000001");
        transaction.setTransaction(transactionDescription);
        transactionDAO.save(transaction);

        System.out.println(transactionDAO.findAll().get(transactionDAO.findAll().size() - 1).transaction);
    }
}
