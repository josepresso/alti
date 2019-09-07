package com.example.demo.service;

import com.example.demo.model.TransactionRequest;
import com.example.demo.model.TransactionResponse;
import com.example.demo.entity.Transaction;

import java.text.ParseException;

public interface TransactionService {

    TransactionResponse getStatistics();

    Transaction saveTransaction(TransactionRequest transactionRequest) throws ParseException;

    void deleteTransaction();
}
