package com.citytech.transaction.resource;

import com.citytech.transaction.service.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 *rest api for transaction management
 */
@RestController
@RequestMapping(path = "/api/v1/transactions")
public class TransactionResource {

    private final ITransactionService transactionService;

    @Autowired
    public TransactionResource(ITransactionService transactionService) {
        this.transactionService = transactionService;
    }

    /**
     * get all transactions
     * @return
     */
    @GetMapping("/all")
    public ResponseEntity<?> allTransactions() {
        return new ResponseEntity(this.transactionService.allTransactions(), HttpStatus.OK);
    }

    /**
     * get transaction of current month
     * @return
     */
    @GetMapping("/month")
    public ResponseEntity<?> monthTransactions(@RequestParam(name="month") final int month) {
        return new ResponseEntity(this.transactionService.monthTransactions(month), HttpStatus.OK);
    }

    /**
     * get transaction of current day
     * @return
     */
    @GetMapping("/today")
    public ResponseEntity<?> todayTransactions() {
        return new ResponseEntity(this.transactionService.todayTransactions(), HttpStatus.OK);
    }
}
