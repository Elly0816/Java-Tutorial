
public class Main {
    public static void main(String[] args) {

        Customer firstCustomer = new Customer();
        System.out.println("\n");
        Customer secondCustomer = new Customer("Google", "google.co@gmail.com");
        System.out.println("\n");
        Customer thirdCustomer = new Customer("Microsoft", 12_000_000_000.55, "microsoft@live.co");

        // firstCustomer.printInfo();
        // System.out.println("\n");
        // secondCustomer.printInfo();
        // System.out.println("\n");
        // thirdCustomer.printInfo();
        // System.out.println("\n");
        // Car carrera = new Car("Porsche", "Carrera", "red", 2, true);
        // carrera.describeCar();
        // Car targa = new Car();
        // targa.describeCar();
        // String make = targa.getMake();
        // String model = targa.getModel();

        // System.out.println("The make of the car is " + make);
        // boolean isConvertible = targa.isConvertible();

        // System.out.println("The " + make + " " + model + " " + (isConvertible ? "is"
        // : "is not") + " a convertible");
        // targa.setMake("Mercedes");
        // targa.setModel("Targa");
        // targa.setColour("red");
        // targa.setDoors(2);
        // targa.setConvertible(true);
        // targa.describeCar();

        // Car benz = new Car();
        // benz.setMake("Porsche");
        // benz.setModel("Targa");
        // benz.setConvertible(false);
        // benz.describeCar();

        // Account eleazarAccount = new Account(23442, 20003.24, "Eleazar",
        // "elzoremmanuel@gmail.com", "+23409028746");
        // Account eleazarAccount = new Account();
        // Account eleazarAccount2 = new Account(123151535, 23226.262, "Eleazar Udo",
        // "elzoremmanuel@gmail.com",
        // "+2348023413241");
        // Account eleazarAccount3 = new Account("Eliezer", "eliezer.emmy@yahoo.com",
        // "+120917465");

        // eleazarAccount.getInfo();
        // System.out.println("\n\n");
        // eleazarAccount2.getInfo();
        // System.out.println("\n\n");
        // eleazarAccount3.getInfo();
        // eleazarAccount.setCustomerName("Eleazar");
        // eleazarAccount.setBalance(25000);
        // double initialBalance = eleazarAccount.getBalance();
        // eleazarAccount.setEmail("elzoremmanuel@gmail.com");
        // eleazarAccount.setPhoneNumber("+2348021875823");
        // eleazarAccount.withdrawFunds(1000000.35);
        // eleazarAccount.withdrawFunds(1000.35);
        // eleazarAccount.depositFunds(2508.83);
        // eleazarAccount.setNumber(2934629);
        // double currentBalance = eleazarAccount.getBalance();
        // String email = eleazarAccount.getEmail();
        // String name = eleazarAccount.getCustomerName();
        // String phoneNumber = eleazarAccount.getPhoneNumber();
        // long number = eleazarAccount.getNumber();
        // System.out.println("Hi " + name + ", with number " + number + "\nYour initial
        // balance was $" + initialBalance
        // + ", however, your current balance is $" + currentBalance
        // + ".\nWe will reach you on at your give email: " + email + " or via SMS at "
        // + phoneNumber + ".");

    }
}