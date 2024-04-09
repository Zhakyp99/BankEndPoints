package com.example.solidbank.controller;

import com.example.solidbank.*;
//import com.example.solidbank.request.AccountRequest;
import com.example.solidbank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    @Autowired
    private AccountService accountService;
    @Autowired
    private TransactionDeposit transactionDeposit;
    @Autowired
    private TransactionWithdraw transactionWithdraw;

    //ok
    @GetMapping
    public ResponseEntity<List<Account>> getAllAccounts() {
        List<Account> accounts = accountService.getAllAccounts();
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    //ok
    @PostMapping
    public ResponseEntity<String> createAccount(@RequestParam AccountType accountType,
                                                @RequestParam String clientID) {
        accountService.createAccount(accountType, clientID);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Account created successfully");
    }

    //ok
    @GetMapping("/{account_id}")
    public ResponseEntity<Account> getAccountById(@PathVariable("account_id") String accountId) {
        Account account = accountService.getAccountById(accountId);
        if (account == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    //ok
    @DeleteMapping("/{account_id}")
    public ResponseEntity<Void> deleteAccountById(@PathVariable("account_id") String accountId) {
        accountService.deleteAccountById(accountId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/{account_id}/withdraw")
    public ResponseEntity<String> withdrawFromAccount(@PathVariable("account_id") String accountId,
                                                      @RequestParam double amount) {
        Account account = accountService.getAccountById(accountId);
        if (account == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Account not found");
        }
        transactionWithdraw.execute((AccountWithdraw) account, amount);
        return ResponseEntity.ok("Withdrawal successful");
    }

    @PostMapping("/{account_id}/deposit")
    public ResponseEntity<String> depositToAccount(@PathVariable("account_id") String accountId,
                                                   @RequestParam double amount) {
        Account account = accountService.getAccountById(accountId);
        if (account == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Account not found");
        }
        transactionDeposit.execute(account, amount);
        return ResponseEntity.ok("Deposit successful");
    }

    //ok
    @GetMapping("/{id}/transactions")
    public ResponseEntity<Optional<Transaction>> getAccountTransactions(@PathVariable("id")
                                                                        String id) {
        Optional<Transaction> transactions = accountService.getAccountTransactions(id);
        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }
}
