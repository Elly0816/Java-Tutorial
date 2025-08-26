public class GasPoweredCar extends Car {
    private double avgKmPerLitre;
    private int cylinders;

    public GasPoweredCar(String desc) {
        this(desc, 0, 0, 0, 0);
    }

    public GasPoweredCar(String description, double topSpeed, double accelleration, double avgKmPerLitre,
            int cylinders) {
        super(description, topSpeed, accelleration);
        this.avgKmPerLitre = avgKmPerLitre;
        this.cylinders = cylinders;
    }

    /**
     * @return the avgKmPerLitre
     */
    public double getAvgKmPerLitre() {
        return avgKmPerLitre;
    }

    /**
     * @return the cylinders
     */
    public int getCylinders() {
        return cylinders;
    }

    public String getGasPoweredCarDetails() {

        return String.format("%sThis is a gas powered car with %d cylinders and does %.2f KM per liter",
                super.getCarDetails(), this.cylinders, this.avgKmPerLitre);
    }

}