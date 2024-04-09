package com.example.solidbank;

import org.springframework.stereotype.Service;

@Service
public class AccountWithdrawServiceImpl implements AccountWithdrawService{
    private AccountDAO accountDAO;
    public AccountWithdrawServiceImpl(AccountDAO accountDAO){
        this.accountDAO = accountDAO;
    }
    @Override
    public void withdraw(double amount, AccountWithdraw account) {
        account
                .setBalance(account.getBalance()-amount);
        accountDAO.save(account);
    }
}
