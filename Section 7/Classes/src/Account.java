public class Account {
    public static void main(String[] args) {

    }

    // private properties
    private String number;
    private double balance;
    private String customerName;
    private String email;
    private String phoneNumber;

    //Constructor
    /**
     * @param Leave empty for object with default arguments
     * @param Pass in arguments to have your own object
     * @return Returns an account object with a number. balance. customer name, email and 
     * phone number
     */
    public Account(){
    this("0000", -5.00,
    "Default Name", "default email", "Default Phone");
        System.out.println("Empty constructor called");
    }
    
    public Account(String number, double balance, String customerName,
    String email, String phoneNumber){
        System.out.println("Constructor with arguments called");
        this.number = number;
        if (balance >= 0){
            this.balance = balance;
        } else  {
            this.balance = 0;
        }
        this.customerName = customerName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Account(String customerName, String email, String phoneNumber){
        this("0000", -5.00,
    customerName, email, phoneNumber);
        // this.customerName = customerName;
        // this.email = email;
        // this.phoneNumber = phoneNumber;
    }

    // functional methods
    public void deposit(double amount) {
        this.balance += amount;
        System.out.println(amount + " was successfully dpeosited, your current balance is now: $" + this.balance);
    }

    public void withdraw(double amount) {
        if ((this.balance - amount) < 0) {
            System.out.println("You do not have enough funds, Current balance is: $" + this.balance);
        } else {
            this.balance -= amount;
            System.out.println("Withdraw Successful, your remaining balance is: $" + this.balance);
        }
    }

    // Getters
    public String getNumber() {
        return this.number;
    }

    public String getBalance() {
        return "$" + this.balance;
    }

    public String getCustomerName() {
        return this.customerName;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    // Setters
    // public void setNumber(String number) {
    //     this.number = number;
    // }

    // public void setBalance(double balance) {
    //     this.balance = balance;
    // }

    // public void setCustomerName(String customerName) {
    //     this.customerName = customerName;
    // }

    // public void setEmail(String email) {
    //     this.email = email;
    // }

    // public void setPhoneNumber(String phoneNumber) {
    //     this.phoneNumber = phoneNumber;
    // }

}
