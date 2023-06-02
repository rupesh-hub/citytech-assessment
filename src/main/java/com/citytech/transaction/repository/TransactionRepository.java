package com.citytech.transaction.repository;

import com.citytech.transaction.entity.Transaction;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
public class TransactionRepository {

    private List<Transaction> transactions = new ArrayList<>();

    @PostConstruct
    public List<Transaction> allTransactions() {
        this.transactions.add(new Transaction(2000d, "Rastriya Badijya Bank", LocalDateTime.now(), "Putalisadak", 12345L));
        this.transactions.add(new Transaction(1000d, "Sanima Bank", LocalDateTime.of(2023, 01, 05, 04, 50, 11), "Satdobato", 54321L));
        this.transactions.add(new Transaction(500d, "Global Bank", LocalDateTime.of(2023, 03, 05, 04, 50, 11), "Lagankhel", 34523L));
        this.transactions.add(new Transaction(700d, "Sunrise Bank", LocalDateTime.of(2023, 06, 02, 04, 50, 11), "Hattisar", 98456L));
        this.transactions.add(new Transaction(700d, "Sunrise Bank", LocalDateTime.of(2023, 06, 02, 07, 40, 04), "Kamalpokhari", 2342L));
        return this.transactions;
    }

    public List<Transaction> todayTransaction() {
        final List<Transaction> transactions =
                this.transactions.stream().filter(transaction ->
                        Objects.equals(transaction.getTransactionDateTime().getDayOfMonth(), LocalDateTime.now().getDayOfMonth())
                        && Objects.equals(transaction.getTransactionDateTime().getMonth(), LocalDateTime.now().getMonth()))
                        .collect(Collectors.toList());
        return transactions;
    }

    public List<Transaction> monthTransaction(int month) {
        final List<Transaction> transactions =
                this.transactions.stream().filter(transaction ->
                                Objects.equals(transaction.getTransactionDateTime().getMonthValue(), month))
                        .collect(Collectors.toList());
        return transactions;
    }

}
