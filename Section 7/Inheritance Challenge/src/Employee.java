public class Employee extends Worker {

    private long employeeId;
    private String hireDate;
    private static long employeeNumber = 0;

    public Employee(String name, String birthDate, String hireDate) {
        super(name, birthDate);
        this.hireDate = hireDate;
        this.employeeId = ++Employee.employeeNumber;
    }

    /**
     * @return the employeeId
     */
    public long getEmployeeId() {
        return employeeId;
    }

    public static long getNumberOfEmployees() {
        return Employee.employeeNumber;
    }

    /**
     * @return the hireDate
     */
    public String getHireDate() {
        return hireDate;
    }

    @Override
    public String toString() {
        return "{" +
                " employeeId='" + getEmployeeId() + "'" +
                ", hireDate='" + getHireDate() + "'" +
                "}" + super.toString();
    }

}
