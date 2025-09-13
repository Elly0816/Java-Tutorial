package dev.ele;

import java.util.ArrayList;

public record Customer(String name, ArrayList<Double> transactions) {
    public Customer(String name) {
        this(name.toUpperCase(), new ArrayList<>());
    }

    public Customer(String name, double InitialDeposit) {
        this(name.toUpperCase(), new ArrayList<>());
        this.addTransaction(InitialDeposit);
    }

    public void addTransaction(double transaction) {
        this.transactions.add(transaction);
    }
};