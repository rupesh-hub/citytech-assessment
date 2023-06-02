package com.citytech.transaction;

import com.citytech.transaction.entity.Transaction;
import com.citytech.transaction.repository.TransactionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class DemoTransactionApplicationTests {

	@Autowired
	private TransactionRepository transactionRepository;

	@Test
	void contextLoads() {

	}

	@Test
	void testGetAllTransactions(){
		List<Transaction> transactions = this.transactionRepository.allTransactions();
		Assert.notEmpty(transactions,"needs to have some transaction value");
	}

	@Test
	void testGetMonthTransaction(){
		final int defaultMonth = LocalDateTime.now().getMonthValue();
		List<Transaction> transactions = this.transactionRepository.monthTransaction(defaultMonth);

		Assert.hasLength("3", "exact size to be of 3.");
	}

	@Test
	void testGetTodayTransaction(){
		List<Transaction> transactions = this.transactionRepository.todayTransaction();
		Assert.notEmpty(transactions,"size of data needs to be 3.");
	}

}
