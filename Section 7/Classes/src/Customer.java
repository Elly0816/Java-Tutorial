public class Customer{
    public static void main(String[] args) {
        
    }

    private String name;
    private String creditLimit;
    private String email;

    public Customer(){
        this("default name", "default Credit", "default email");
    };

    public Customer(String name, String creditLimit, String email){
        this.name = name;
        this.creditLimit = creditLimit;
        this.email = email;
    };
    
    public Customer(String name, String email){
        this(name, "default Credit", email);
    };

    public String getName(){
        return this.name;
    }

    public String getCredit(){
        return this.creditLimit;
    }

    public String getEmail(){
        return this.email;
    }
}