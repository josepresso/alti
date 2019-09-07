package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotNull;

public class TransactionRequest {

    @NotNull
    private Double amount;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")//2014-07-04T12:08:56.235-0700
    private String time;

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
