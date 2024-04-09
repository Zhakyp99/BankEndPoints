package com.example.solidbank;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UuidGenerator;

@NoArgsConstructor
@Entity
@Table(name = "account")
@AllArgsConstructor
@Builder
public class Account {
    private AccountType accountType;
    @Id
    @Column(name = "id", length = 255)
    private String id;
    private String clientID;
    private double balance;
    private boolean withdrawAllowed;

    public double getBalance(){
        return balance;
    }
    @Override
    public String toString(){
        return "Account{" +
                "accountType=" + accountType +
                ", id='" + id + '\'' +
                ", clientId='" + clientID + '\'' +
                ", balance=" + balance +
                ", withdrawAllowed=" + withdrawAllowed +
                '}';
    }

    public String getClientID() {
        return clientID;
    }

    public void setClientID(String clientID) {
        this.clientID = clientID;
    }


    public boolean isWithdrawAllowed() {
        return withdrawAllowed;
    }

    public void setWithdrawAllowed(boolean withdrawAllowed) {
        this.withdrawAllowed = withdrawAllowed;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
