public class HourlyEmployee extends Employee{


    private double hourlyPayRate;


    public HourlyEmployee(String name,
     String birthdate,
     String hireDate, 
     double hourlyPayRate){
        super(name, birthdate, hireDate);
        this.hourlyPayRate = hourlyPayRate;
    }

    public double getDoublePay(){
        return hourlyPayRate * 80;
    }

    public double collectPay(){
        return 40*hourlyPayRate;
    }


    @Override
    public String toString() {
        return "{" +
            " hourlyPayRate='" + hourlyPayRate + "'" +
            "}" +super.toString();
    }

}