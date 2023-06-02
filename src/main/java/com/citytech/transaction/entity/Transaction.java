package com.citytech.transaction.entity;

import java.time.LocalDateTime;

public class Transaction {

    private Double amount;
    private String merchantName;
    private LocalDateTime transactionDateTime;
    private String merchantAddress;
    private Long invoiceNumber;

    public Transaction(){}

    public Transaction(Double amount, String merchantName, LocalDateTime transactionDateTime, String merchantAddress, Long invoiceNumber) {
        this.amount = amount;
        this.merchantName = merchantName;
        this.transactionDateTime = transactionDateTime;
        this.merchantAddress = merchantAddress;
        this.invoiceNumber = invoiceNumber;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public LocalDateTime getTransactionDateTime() {
        return transactionDateTime;
    }

    public void setTransactionDateTime(LocalDateTime transactionDateTime) {
        this.transactionDateTime = transactionDateTime;
    }

    public String getMerchantAddress() {
        return merchantAddress;
    }

    public void setMerchantAddress(String merchantAddress) {
        this.merchantAddress = merchantAddress;
    }

    public Long getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(Long invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }
}
