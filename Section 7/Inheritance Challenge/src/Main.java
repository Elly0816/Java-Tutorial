public class Main {
    public static void main(String[] args) {
        // Worker james = new Worker("James", "10/5/1992", "5/3/2025");
        // System.out.println("James is " + james.getAge() + " years old");

        SalariedEmployee may = new SalariedEmployee("May", "20-6-1995", "12-3-2020", 60_135.85,
                false);
        HourlyEmployee mark = new HourlyEmployee("Mark", "20-6-1995", "12-3-2020", 32.45);

        SalariedEmployee joe = new SalariedEmployee("Joe", "20-6-1995", "12-3-2020", 32_442.45, false);

        HourlyEmployee jake = new HourlyEmployee("Jake", "20-6-1995", "12-3-2020", 60.44);
        may.retire("20/05/2025");
        mark.getDoublePay();
        System.out.println(may);
        System.out.println(mark);
        System.out.println(joe);
        System.out.println(jake);

        System.out.println(joe.getName() + "'s salary is $" + joe.collectPay());
        joe.retire("22/08/2025");
        System.out.println(joe.getName() + "'s salary after retirement is $" + joe.collectPay());
    }
}
