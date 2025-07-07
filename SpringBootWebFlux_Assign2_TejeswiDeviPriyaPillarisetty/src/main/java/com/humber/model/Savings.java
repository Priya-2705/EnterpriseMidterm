package com.humber.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("savings")
public class Savings implements Account {

    @Id
    private String id;
    private String accountHolder;
    private double balance;
    private double interestRate;

    @Override
    public void deposit(double amount) {
        balance += amount;
    }

    @Override
    public void withdrawal(double amount) {
        balance -= amount;
    }

    @Override
    public void updateBalance(double newBalance) {
        balance = newBalance;
    }

    public void depositMonthlyInterest() {
        balance += (balance * interestRate / 100);
    }
}