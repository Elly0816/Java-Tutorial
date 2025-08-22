import java.time.Year;

public class Worker {
    private String name;
    private String birthDate;
    private String endDate;

    public Worker(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
        // this.endDate = endDate;
    }

    /**
     * @return the birthDate
     */
    public String getBirthDate() {
        return birthDate;
    }

    /**
     * @return the endDate
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    public int getAge() {
        int currentYear = Year.now().getValue();

        int birthYear = Integer.parseInt(birthDate.split("[/\\-_]")[birthDate.split("[/\\-_]").length - 1]);
        System.out.println("The birthYear is " + birthYear);

        return currentYear - birthYear;
    }

    public double collectPay() {
        return 50_000.25;
    }

    public void terminate(String endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "{" +
                " name='" + getName() + "'" +
                ", birthDate='" + getBirthDate() + "'" +
                ", endDate='" + getEndDate() + "'" +
                "}";
    }

}
