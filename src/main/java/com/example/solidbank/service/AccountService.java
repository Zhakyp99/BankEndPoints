package com.example.solidbank.service;

import com.example.solidbank.*;
//import com.example.solidbank.request.AccountRequest;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class AccountService {
    @Autowired
    private AccountDAO accountDAO;
    @Autowired
    private TransactionDAO transactionDAO;
    @Autowired
    private BankCore bankCore;
    @Autowired
    private TransactionDeposit transactionDeposit;
    @Autowired
    private TransactionWithdraw transactionWithdraw;


    //ok
    public List<Account> getAllAccounts() {
        return accountDAO.findAll();
    }

    //ok
    public Account getAccountById(String accountId) {
        return accountDAO.
                findById(accountId).orElse(null);
    }

    //ok
    public void createAccount(AccountType accountType, String clientID) {
        bankCore.createNewAccount(accountType, clientID);
    }


    //ok
    public void deleteAccountById(String accountId) {
        accountDAO.deleteById(accountId);
    }

    //ok
    public Optional<Transaction> getAccountTransactions(String id) {
        Account account = accountDAO.findById(id).orElse(null);
        if (account != null) {
            return transactionDAO.findById(id);
        } else {
            throw new IllegalArgumentException("Account not found");
        }
    }

    @Transactional
    public void withdrawFromAccount(String accountId, double amount) {
        Account account = accountDAO.findById(accountId).orElse(null);
        if (account == null) {
            throw new IllegalArgumentException("Account not found");
        }
        transactionWithdraw.execute((AccountWithdraw) account, amount);
    }

    @Transactional
    public void depositToAccount(String accountId, double amount) {
        Account account = accountDAO.findById(accountId).orElse(null);
        if (account == null) {
            throw new IllegalArgumentException("Account not found");
        }
        transactionDeposit.execute(account, amount);
    }



}
