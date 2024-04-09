package com.example.solidbank;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionDAO extends JpaRepository<Transaction,String> {
    List<Transaction> findByAccountId(String accountId);
    Optional<Transaction> findById(String id);
}
