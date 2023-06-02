package com.citytech.transaction.service;

import com.citytech.transaction.entity.Transaction;

import java.util.List;

public interface ITransactionService {

    List<Transaction> allTransactions();
    List<Transaction> monthTransactions(int month);
    List<Transaction> todayTransactions();


}
