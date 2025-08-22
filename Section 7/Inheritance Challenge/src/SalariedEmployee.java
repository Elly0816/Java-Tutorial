public class SalariedEmployee extends Employee {

    private double annualSalary;
    private boolean isRetired;

    public SalariedEmployee(String name, String birthDate, String hireDate,
            double annualSalary, boolean isRetired) {
        super(name, birthDate, hireDate);
        this.annualSalary = annualSalary;
        this.isRetired = isRetired;
    }

    /**
     * @return the annualSalary
     */
    private double getAnnualSalary() {
        return this.isRetired ? annualSalary * 0.9 : annualSalary;
    }

    @Override
    public double collectPay() {
        return (int) this.getAnnualSalary() / 26;
    }

    /**
     * @return the isRetired
     */
    public boolean isRetired() {
        return this.isRetired;
    }

    public void retire(String endDate) {
        terminate(endDate);
        this.isRetired = true;
        System.out.println(this.getName() + " retired on " + this.getEndDate());
    }

    @Override
    public String toString() {
        return "{" +
                " annualSalary='" + getAnnualSalary() + "'" +
                ", isRetired='" + isRetired() + "'" +
                "}" + super.toString();
    }

}
