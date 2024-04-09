package com.example.solidbank;

import org.springframework.stereotype.Service;

@Service
public class AccountCreationServiceImpl implements AccountCreationService{
    private AccountDAO accountDAO;
    public AccountCreationServiceImpl(AccountDAO accountDAO){
        this.accountDAO = accountDAO;
    }

    /*@Override
    public void create(AccountType accountType, long bankID,
                       String clientID, long accountID) {
        String id = String.format("%03d%06d", bankID, accountID);

        switch (accountType) {
            case SAVING :
            {
                Account account = new Account(accountType, id, clientID, 0, true);
                accountDAO.save(account);
                break;
            }
            case CHECKING:{
                Account account = new Account(accountType, id, clientID, 0, true);
                accountDAO.save(account);
                break;
            }
            case FIXED :{

                Account account = new Account(accountType, id, clientID, 0,false);
                accountDAO.save(account);
                break;
            }
            default :{
                throw new IllegalStateException("Unexpected value: " + accountType);
            }
        };

    }*/

    @Override
    public void create(AccountType accountType, long bankID, String clientID, long accountID) {
        String id = String.format("%03d%06d", bankID, accountID);
        Account account = switch (accountType) {
            case SAVING -> new SavingAccount(accountType, id, clientID, 0);
            case CHECKING-> new CheckingAccount(accountType, id, clientID, 0);
            case FIXED -> new FixedAccount(accountType, id, clientID, 0);
            default -> throw new IllegalStateException("Unexpected value: " + accountType);
        };
        accountDAO.save(account);
    }


}
