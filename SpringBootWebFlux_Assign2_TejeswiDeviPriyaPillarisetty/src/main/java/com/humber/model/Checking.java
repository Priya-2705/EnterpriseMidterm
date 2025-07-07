package com.humber.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("checking")
public class Checking implements Account {

    @Id
    private String id;
    private String accountHolder;
    private double balance;
    private double insufficientFundFee;

    @Override
    public void deposit(double amount) {
        balance += amount;
    }

    @Override
    public void withdrawal(double amount) {
        if (balance < amount) {
            balance -= insufficientFundFee;
        } else {
            balance -= amount;
        }
    }

    @Override
    public void updateBalance(double newBalance) {
        balance = newBalance;
    }

    public void processingCheck(String checkId) {
        // Dummy processing
    }
}