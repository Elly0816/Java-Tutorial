package dev.ele;

public class Main {
    public static void main(String[] args) {
        Bank secureTrust = new Bank("Secure Trust");
        secureTrust.addNewCustomer("Eleazar", 7000);
        secureTrust.addNewCustomer("Bethel", 7000);
        secureTrust.addNewCustomer("Jeremiah", 4000);
        secureTrust.addTransaction("Jeremiah", "Bethel", 2000);
        secureTrust.addTransaction("Bethel", "Eleazar", 3000);
        secureTrust.addTransaction("Eleazar", "Jeremiah", 4000);
        secureTrust.addTransaction("Eleazar", "Eleazar", 4000);
        secureTrust.addTransaction("Eleazar", "Mary", 4000);
        for (Customer c : secureTrust.getCustomers()) {
            secureTrust.printStatement(c.name());
        }
    }
}