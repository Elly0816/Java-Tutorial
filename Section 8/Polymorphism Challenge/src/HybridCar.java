public class HybridCar extends Car {

    private double avgKmPerLitre;
    private int batterySize;
    private int cylinders;

    public HybridCar(String desc) {
        this(desc, 0, 0, 0, 0, 0);
    }

    public HybridCar(String description, double topSpeed, double accelleration, double avgKmPerLitre,
            int cylinders, int batterySize) {
        super(description, topSpeed, accelleration);
        this.avgKmPerLitre = avgKmPerLitre;
        this.cylinders = cylinders;
        this.batterySize = batterySize;
    }

    /**
     * @return the avgKmPerLitre
     */
    public double getAvgKmPerLitre() {
        return avgKmPerLitre;
    }

    /**
     * @return the batterySize
     */
    public int getBatterySize() {
        return batterySize;
    }

    /**
     * @return the cylinders
     */
    public int getCylinders() {
        return cylinders;
    }

    public String getHybridCarDetails() {
        return String.format(
                "%sThis is a hybrid car with a battery size of %d,  %d cylinders and does %.2f KM per liter",
                super.getCarDetails(), this.batterySize, this.cylinders, this.avgKmPerLitre);
    }

    @Override
    public void drive() {
        super.drive();
        System.out.println("The battery is being charged");
    }
}