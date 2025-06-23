
public class Main {
    public static void main(String[] args) {

        Customer myCustomer = new Customer();
        System.out.println("Customer name: " +myCustomer.getName());
        System.out.println("Customer email: " +myCustomer.getEmail());
        System.out.println("Customer credit: " +myCustomer.getCredit());
        System.out.println("\n");
        
        
        Customer myCustomer1 = new Customer("customer1 name", "customer1 email");
        System.out.println("Customer1 name: " +myCustomer1.getName());
        System.out.println("Customer1 email: " +myCustomer1.getEmail());
        System.out.println("Customer1 credit: " +myCustomer1.getCredit());
        System.out.println("\n");
        
        Customer myCustomer3 = new Customer("customer3 name", "customer3 credit",
        "customer3 email");
        System.out.println("Customer3 name: " +myCustomer3.getName());
        System.out.println("Customer3 email: " +myCustomer3.getEmail());
        System.out.println("Customer3 credit: " +myCustomer3.getCredit());
        
        

        // Account myAccount = new Account("1234", 5000.00,
        // //  "Eleazar Udo", "eleazarEmail@gmail.com", "+123456789");
        // Account myAccount = new Account("My name",
        //  "myEmail@gmail.com",
        //   "my Phone Number");

        // System.out.println(myAccount.getNumber());
        // System.out.println(myAccount.getBalance());
        // System.out.println(myAccount.getCustomerName());
        // System.out.println(myAccount.getEmail());
        // System.out.println(myAccount.getPhoneNumber());

        // Car car = new Car();
        // car.describeCar();
        // System.out.println("Color = " + car.getColor());
        // System.out.println("Doors = " + car.getDoors());
        // System.out.println("Make = " + car.getMake());
        // System.out.println("Model = " + car.getModel());
        // System.out.println("Convertible = " + car.getConvertible());

        // car.setColor("Red");
        // car.setConvertible(true);
        // car.setDoors(2);
        // car.setMake("Porsche");
        // car.setModel("911");

        // System.out.println("Doors = " + car.getDoors());
        // System.out.println("Make = " + car.getMake());
        // System.out.println("Model = " + car.getModel());

        // Car targa = new Car();

        // targa.setColor("Blue");
        // targa.setConvertible(false);
        // targa.setDoors(2);
        // targa.setMake("Porsche");
        // targa.setModel("Targa");

        // targa.describeCar();
    }
}