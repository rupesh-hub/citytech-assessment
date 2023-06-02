package com.citytech.transaction.service;

import com.citytech.transaction.entity.Transaction;
import com.citytech.transaction.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService implements ITransactionService {

    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public List<Transaction> allTransactions() {
        return Optional.ofNullable(transactionRepository.allTransactions())
                .orElse(null);
    }

    @Override
    public List<Transaction> monthTransactions(final int month) {
        return Optional.ofNullable(transactionRepository.monthTransaction(month))
                .orElse(null);
    }

    @Override
    public List<Transaction> todayTransactions() {
        return Optional.ofNullable(transactionRepository.todayTransaction())
                .orElse(null);
    }
}
