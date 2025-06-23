public class Main{
    public static void main(String[] args) {
        
        Employee elly = new Employee("Elly", "08-16-1997", "03-03-2023");
        System.out.println(elly);
        System.out.println("Age = " +elly.getAge());
        System.out.println("Pay = " +elly.collectPay());
        System.out.println();
        
        SalariedEmployee joe = new SalariedEmployee("Joe", "11/11/1990", "03/03/2020", 35000);
        System.out.println(joe);
        // System.out.println("Age = " +joe.getAge());
        System.out.println("Joe's paycheck = $" +joe.collectPay());
        
        joe.retire();
        System.out.println("Joe's pension check = $" +joe.collectPay());
        System.out.println();
        
        HourlyEmployee mary = new HourlyEmployee("Mary", "05/05/1970", "03/03/2021", 15);
        System.out.println(mary);
        System.out.println("Mary's paycheck = $" +mary.collectPay());
        System.out.println("Mary's holiday pay = $" +mary.getDoublePay());
        System.out.println();


    }
}