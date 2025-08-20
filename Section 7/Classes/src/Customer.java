class Customer {

    private String name;
    private double credit_limit;
    private String email;

    public Customer() {
        this("Default name", "Default email");
    }

    public Customer(String name, String email) {
        this(name, 1_000, email);
    }

    public Customer(String name, double credit_limit, String email) {
        this.name = name;
        this.credit_limit = credit_limit;
        this.email = email;
        this.printInfo();
    }

    /**
     * @return the credit_limit
     */
    public double getCredit_limit() {
        return credit_limit;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    public void printInfo() {
        System.out
                .println("{\n\tCustomerName: " + this.name + ",\n\tCustomerEmail: " + this.email + ",\n\tCreditLimit: $"
                        + String.format("%,.2f", this.credit_limit) + "\n}");
    }
}