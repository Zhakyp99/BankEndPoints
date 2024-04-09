package com.example.solidbank;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AccountDAO extends JpaRepository<Account,String> {
    //List<Account> getClientAccounts(String clientID);
    //public void createNewAccount(Account account);
    //public void updateAccount(Account account);
    //List<Account> getClientAccountsByType(String clientID,AccountType accountType);
    //public AccountWithdraw getClientWithdrawAccount(String clientID,String accountID);
    //public Account getClientAccount(String clientID, String accountID);

    // Retrieve an account by client ID and account ID
    List<Account> findByClientID(String clientID);
    List<Account> findAccountsByClientIDAndAccountType(String clientID,AccountType accountType);
    //AccountWithdraw findByClientIDAndId(String clientID,String accountID);
    Account findByClientIDAndId(String clientID, String accountID);

}
