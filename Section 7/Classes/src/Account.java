import java.util.regex.Pattern;

public class Account {

    private long number;
    private double balance;
    private String customerName;
    private String email;
    private String phoneNumber;

    /**
     * 
     * @param amount amount to deposit
     */
    public void depositFunds(double amount) {
        if (amount < 0) {
            System.out.println("Invalid amount! " + amount);
            return;
        }

        this.balance += amount;
        System.out.println("Added $" + amount + " to balance. Current balance is now $" + balance);
    }

    /**
     * 
     * @param amount amount to withdraw
     * 
     */
    public void withdrawFunds(double amount) {
        if (amount < 0) {
            System.out.println("Invalid Input");
            return;
        }
        if (amount > this.balance) {
            System.out.println("Insufficient funds");
            return;
        }
        this.balance -= amount;
        System.out.println("Deducted $" + amount + " from balance. Current balance is now $" + balance);
    }

    /**
     * @return the balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * @return the customerName
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return the number
     */
    public long getNumber() {
        return number;
    }

    /**
     * @return the phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param balance the balance to set
     */
    public void setBalance(double balance) {
        if (balance < 0)
            return;
        this.balance = balance;
    }

    /**
     * @param customerName the customerName to set
     */
    public void setCustomerName(String customerName) {
        if (!Pattern.compile("^[A-Za-z ]+$").matcher(customerName).matches()) {
            System.out.println("Name should only contain letters and space!");
            return;
        }
        this.customerName = customerName;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        if (!Pattern.compile("^[A-Za-z]+\\.?[A-Za-z]*[0-9]*@[a-z]+\\.(com|org|net)$").matcher(email).matches()) {
            System.out.println("Invalid Email! ");
            return;
        }
        this.email = email;
    }

    /**
     * @param number the number to set
     */
    public void setNumber(long number) {
        this.number = number;
    }

    /**
     * @param phoneNumber the phoneNumber to set
     */
    public void setPhoneNumber(String phoneNumber) {
        if (!Pattern.compile("^\\+?[0-9]+$").matcher(phoneNumber).matches() || phoneNumber.length() > 15) {
            System.out.println("Invalid Number! ");
            return;
        }
        this.phoneNumber = phoneNumber;
    }
}