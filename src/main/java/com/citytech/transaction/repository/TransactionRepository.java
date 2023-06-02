package com.citytech.transaction.repository;

import com.citytech.transaction.entity.Transaction;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
public class TransactionRepository {

    private List<Transaction> transactions = new ArrayList<>();

    public List<Transaction> allTransactions() {
        this.transactions.add(new Transaction(2000d, "Rastriya Badijya Bank", LocalDateTime.now(), "Putalisadak", 12345L));
        this.transactions.add(new Transaction(1000d, "Sanima Bank", LocalDateTime.of(2023, 01, 05, 04, 50, 11), "Satdobato", 54321L));
        this.transactions.add(new Transaction(500d, "Global Bank", LocalDateTime.of(2023, 03, 05, 04, 50, 11), "Lagankhel", 34523L));
        this.transactions.add(new Transaction(700d, "Sunrise Bank", LocalDateTime.of(2023, 02, 01, 04, 50, 11), "Hattisar", 98456L));
        return this.transactions;
    }

    public List<Transaction> todayTransaction() {
        final Stream<Transaction> transactionStream =
                this.transactions.stream().filter(transaction -> Objects.equals(transaction.getTransactionDateTime(), LocalDateTime.now()));
        return transactionStream.collect(Collectors.toList());
    }

    public List<Transaction> monthTransaction() {
        final Stream<Transaction> transactionStream =
                this.transactions.stream().filter(transaction -> Objects.equals(transaction.getTransactionDateTime(), LocalDateTime.now()));

        return transactionStream.collect(Collectors.toList());
    }

}
