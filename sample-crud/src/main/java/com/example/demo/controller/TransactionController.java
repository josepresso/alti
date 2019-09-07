package com.example.demo.controller;

import com.example.demo.model.TransactionRequest;
import com.example.demo.model.TransactionResponse;
import com.example.demo.service.TransactionService;
import com.example.demo.entity.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;

@RestController
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @GetMapping(value = "/statistics")
    public TransactionResponse statistics() {
        return transactionService.getStatistics();
    }

    @PostMapping("/transaction")
    public ResponseEntity<Transaction> saveTransaction(@Valid @RequestBody TransactionRequest transactionRequest) throws ParseException {
        Transaction transaction = transactionService.saveTransaction(transactionRequest);
        return new ResponseEntity<>(transaction, HttpStatus.CREATED);
    }

    @DeleteMapping("/transaction")
    public ResponseEntity deleteTransaction() {
        transactionService.deleteTransaction();
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
