public class SalariedEmployee extends  Employee{
    
    private double annualSalary;
    private boolean isRetired;


    public SalariedEmployee(String name,
     String birthdate,
     String hireDate,
     double annualSalary){
        super(name, birthdate, hireDate);
        this.annualSalary = annualSalary;
    }

    public void retire(){
        terminate("12/12/2025");
        this.isRetired = true;
    }

    @Override
    public double collectPay(){
        double payCheck = annualSalary/26;
        double adjustedPay = (isRetired) ? 0.9 * payCheck : payCheck;
        return (int) adjustedPay;
    }


    @Override
    public String toString() {
        return "{" +
            " annualSalary='" + annualSalary + "'" +
            ", isRetired='" + isRetired + "'" +
            "}" + super.toString();
    }

}