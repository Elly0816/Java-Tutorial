public class ElectricCar extends Car {

    private double avgKmPerCharge;
    private int batterySize;

    public ElectricCar(String desc) {
        this(desc, 0, 0, 0, 0);
    }

    public ElectricCar(String description, double topSpeed, double accelleration, double avgKmPerCharge,
            int batterySize) {
        super(description, topSpeed, accelleration);
        this.avgKmPerCharge = avgKmPerCharge;
        this.batterySize = batterySize;
    }

    /**
     * @return the batterySize
     */
    public int getBatterySize() {
        return batterySize;
    }

    /**
     * @return the avgKmPerCharge
     */
    public double getAvgKmPerCharge() {
        return avgKmPerCharge;
    }

    public String getElectricCarDetails() {
        return String.format("%sThis is an electric car with batterySize of: %d KWh and does %.2f KM per charge",
                super.getCarDetails(), this.batterySize, this.avgKmPerCharge);
    }

    @Override
    public void drive() {
        System.out.println("Motor is running");
        System.out.println("Car is running");
    }

}