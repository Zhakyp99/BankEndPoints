package com.example.solidbank;



import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.StringDeserializer;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@Entity
@Table(name = "transaction")
public class Transaction {
//    @GeneratedValue (strategy = GenerationType.AUTO)
//    @Id
//    @JsonDeserialize(using = StringDeserializer.class)
//    Long id;

    @Id
    @Column(name = "id", length = 255)
    //@GeneratedValue (strategy = GenerationType.AUTO)
    private String id;
    @Column(name = "account_id", length = 255)
    String accountId;
    String transaction;
    public Transaction(String transaction) {
        this.transaction = transaction;
    }
    public String getTransaction() {
        return transaction;
    }

    public void setTransaction(String transaction) {
        this.transaction = transaction;
    }
}
