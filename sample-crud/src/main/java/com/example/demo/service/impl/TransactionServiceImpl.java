package com.example.demo.service.impl;

import com.example.demo.entity.Transaction;
import com.example.demo.model.TransactionRequest;
import com.example.demo.model.TransactionResponse;
import com.example.demo.service.TransactionService;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class TransactionServiceImpl implements TransactionService {

    private static List<Transaction> transactions = new ArrayList<>();

    @Override
    public synchronized TransactionResponse getStatistics() {
        TransactionResponse transactionResponse = new TransactionResponse();
        if (!transactions.isEmpty()){
            List<Double> amountList = transactions.stream().map(z -> z.getAmount()).collect(Collectors.toList());
            transactionResponse.setAvg(amountList.stream().mapToDouble(v -> v).average().orElseThrow(NoSuchElementException::new));
            transactionResponse.setCount(amountList.stream().count());
            transactionResponse.setMax(amountList.stream().mapToDouble(v -> v).max().orElseThrow(NoSuchElementException::new));
            transactionResponse.setMin(amountList.stream().mapToDouble(v -> v).min().orElseThrow(NoSuchElementException::new));
            transactionResponse.setSum(amountList.stream().mapToDouble(v -> v).sum());
        }
        return transactionResponse;
    }

    @Override
    public synchronized Transaction saveTransaction(TransactionRequest transactionRequest) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        Transaction transaction = new Transaction();
        transaction.setAmount(transactionRequest.getAmount());
        transaction.setTime(formatter.parse(transactionRequest.getTime()));
        transactions.add(transaction);
        return transaction;
    }

    @Override
    public synchronized void deleteTransaction() {
        transactions.clear();
    }
}
