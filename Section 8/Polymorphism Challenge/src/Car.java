public class Car {

    private String description;
    private double topSpeed;
    private double accelleration;

    public Car(String description) {
        this(description, 0, 0);
    }

    public Car(String description, double topSpeed, double accelleration) {
        this.description = description;
        this.topSpeed = topSpeed;
        this.accelleration = accelleration;
    }

    public void startEngine() {

        System.out.println("Car->Engine is starting!");
    }

    public void drive() {
        this.startEngine();
        this.runEngine();
        System.out.println("Car->Car is driving!");

    }

    protected void runEngine() {
        System.out.println("Car->Engine is revving!");

    }

    /**
     * @return the accelleration
     */
    public double getAccelleration() {
        return accelleration;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return the topSpeed
     */
    public double getTopSpeed() {
        return topSpeed;
    }

    public String getCarDetails() {
        return String.format(
                "%s!%nThe car's description: %s %nIt's top speed is %.2f kmph and it does 0-100kmph in %.2f seconds%n",
                this.getClass().getSimpleName(), this.description, this.topSpeed, this.accelleration);
    }

    /**
     * @param accelleration the accelleration to set
     */
    protected void setAccelleration(double accelleration) {
        if (accelleration < 0) {
            this.accelleration = 0;
        }
        this.accelleration = accelleration;
    }

    /**
     * @param description the description to set
     */
    protected void setDescription(String description) {
        this.description = description;
    }

    /**
     * @param topSpeed the topSpeed to set
     */
    protected void setTopSpeed(double topSpeed) {
        if (topSpeed < 0) {
            this.topSpeed = 0;
        }
        this.topSpeed = topSpeed;
    }

    public static Car getCar(String type, String desc) {

        if (type == null || type.trim().isBlank()) {
            return new Car(desc);
        }

        return switch (type.toUpperCase().charAt(0)) {
            case 'E' -> new ElectricCar(desc);
            case 'H' -> new HybridCar(desc);
            case 'G' -> new GasPoweredCar(desc);
            default -> new Car(desc);
        };
    }

    public static void printCar(Car newCar) {
        if (newCar instanceof HybridCar hybrid) {
            System.out.println(hybrid.getHybridCarDetails());
        } else if (newCar instanceof GasPoweredCar ice) {
            System.out.println(ice.getGasPoweredCarDetails());
        } else if (newCar instanceof ElectricCar ev) {
            System.out.println(ev.getElectricCarDetails());
        } else {
            System.out.println(newCar.getCarDetails());
        }
    }

}