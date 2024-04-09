package com.example.solidbank;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountListingServiceImpl implements  AccountListingService{
    private AccountDAO accountDAO;
    public AccountListingServiceImpl(AccountDAO accountDAO){
        this.accountDAO = accountDAO;
    }
    @Override
    public Account getClientAccount(String clientID, String accountID) {
        return accountDAO.findByClientIDAndId(clientID, accountID);
    }

    @Override
    public AccountWithdraw getClientWithdrawAccount(String clientID, String accountID) {
        return (AccountWithdraw) accountDAO.findByClientIDAndId(clientID, accountID);
    }

    @Override
    public List<Account> getClientAccounts(String clientID) {
        return accountDAO.findByClientID(clientID);
    }

    @Override
    public List<Account> getClientAccountsByType(String clientID, AccountType accountType) {
        return accountDAO.findAccountsByClientIDAndAccountType(clientID, accountType);
    }
}
