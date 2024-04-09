package com.example.solidbank;

import org.springframework.stereotype.Component;

@Component
public class TransactionWithdraw {
    private AccountWithdrawService accountWithdrawService;
    private TransactionDAO transactionDAO;

    public TransactionWithdraw(AccountWithdrawService accountWithdrawService, TransactionDAO transactionDAO) {
        this.accountWithdrawService = accountWithdrawService;
        this.transactionDAO = transactionDAO;
    }

    public void execute(AccountWithdraw account, double amount) {
        if (account.getBalance() > amount) {
            accountWithdrawService.withdraw(amount, account);

            String transactionDescription = String.format("%.2f$ transferred to %s account", amount, account.getId());
            Transaction transaction = new Transaction();
            transaction.setId("001000001");
            transaction.setTransaction(transactionDescription);
            transactionDAO.save(transaction);

            System.out.println(transactionDAO.findAll().get(transactionDAO.findAll().size() - 1).transaction);
        } else {
            System.out.println("You do not have sufficient funds for this operation");
        }
    }
}
