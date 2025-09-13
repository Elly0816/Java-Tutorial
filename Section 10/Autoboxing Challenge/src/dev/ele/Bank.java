package dev.ele;

import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Customer> customers;

    public Bank(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
    }

    private Customer findCustomer(String name) {
        for (Customer customer : customers) {
            if (customer.name().toLowerCase().equals(name.toLowerCase())) {
                return customer;
            }
        }
        // System.out.println(name + " is not a customer");
        return null;
    }

    public boolean addNewCustomer(String name) {
        Customer customerInBank = this.findCustomer(name);
        if (customerInBank == null) {
            customers.add(new Customer(name));
            System.out.println(name + " added");
            return true;
        }
        return false;
    }

    public boolean addNewCustomer(String name, double initialDeposit) {
        Customer customerInBank = this.findCustomer(name);
        if (customerInBank == null) {
            customers.add(new Customer(name, initialDeposit));
            System.out.println(name + " added with an initial deposit of " + initialDeposit);
            return true;
        }
        return false;
    }

    public boolean addTransaction(String name, double transaction) {
        Customer customerInBank = this.findCustomer(name);
        if (customerInBank != null) {
            customerInBank.addTransaction(transaction);
            System.out.println("Transaction of " + transaction + " added");
            return true;
        }
        System.out.println(name + " is not a customer");
        return false;
    }

    public boolean addTransaction(String sendingCustomerName, String receivingCustomerName, double transaction) {
        Customer sendingCustomer = this.findCustomer(sendingCustomerName);
        Customer receivingCustomer = this.findCustomer(receivingCustomerName);

        if (sendingCustomer == null || receivingCustomer == null) {
            if (sendingCustomer == null) {
                System.out.println(sendingCustomerName + " is not a customer");
            }
            if (receivingCustomer == null) {
                System.out.println(receivingCustomerName + " is not a customer");
            }
            return false;
        }

        if (sendingCustomer.equals(receivingCustomer)) {
            System.out.println("You cannot send money to yourself");
            return false;
        }

        sendingCustomer.addTransaction(-transaction);
        receivingCustomer.addTransaction(transaction);
        return true;

    }

    public void printStatement(String name) {
        Customer customer = this.findCustomer(name);
        if (customer == null) {
            System.out.println(name + " is not a customer");
            return;
        }
        System.out.format("Customer name: %s%n", customer.name());
        System.out.println("Transactions:");
        int i = 1;
        for (var t : customer.transactions()) {
            System.out.format("%d. %.2f %s%n", i++, t, t >= 0 ? "credit" : "debit");
        }
        System.out.println("_".repeat(40));
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<Customer> getCustomers() {
        return this.customers;
    }

}