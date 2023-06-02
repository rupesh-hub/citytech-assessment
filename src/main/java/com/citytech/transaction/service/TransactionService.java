package com.citytech.transaction.service;

import com.citytech.transaction.entity.Transaction;
import com.citytech.transaction.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService implements ITransactionService{

    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public List<Transaction> allTransactions() {
        return transactionRepository.allTransactions();
    }

    @Override
    public List<Transaction> monthTransactions() {
        return transactionRepository.monthTransaction();
    }

    @Override
    public List<Transaction> todayTransactions() {
        return transactionRepository.todayTransaction();
    }
}
