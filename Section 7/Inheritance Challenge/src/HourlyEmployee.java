public class HourlyEmployee extends Employee {

    private double hourlyPayRate;

    public HourlyEmployee(String name, String birthDate, String hireDate,
            double hourlyPayRate) {
        super(name, birthDate, hireDate);
        this.hourlyPayRate = hourlyPayRate;
    }

    /**
     * @return the hourlyPayRate
     */
    public double getHourlyPayRate() {
        return hourlyPayRate;
    }

    public void getDoublePay() {
        System.out.println(this.getName() + " just received " + this.collectPay() * 2 + " for 2 weeks of work.");
    }

    @Override
    public double collectPay() {
        return 40 * this.getHourlyPayRate();
    }

    @Override
    public String toString() {
        return "{" +
                " hourlyPayRate='" + getHourlyPayRate() + "'" +
                "}" + super.toString();
    }

}
