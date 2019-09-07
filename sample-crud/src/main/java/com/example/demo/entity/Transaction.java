package com.example.demo.entity;

import java.util.Date;

public class Transaction {

    private Double amount;
    private Date time;

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
