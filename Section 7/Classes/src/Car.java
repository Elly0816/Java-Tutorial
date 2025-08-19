public class Car {

    private String make = "Tesla";
    private String model = "Model-X";
    private String colour = "Gray";
    private int doors = 2;
    private boolean convertible = true;

    // public Car(String make, String model, String colour, int doors, boolean
    // convertible) {
    // this.make = make;
    // this.model = model;
    // this.colour = colour;
    // this.doors = doors;
    // this.convertible = convertible;
    // }

    /**
     * 
     * @Elly0816
     *           Prints out a description of the car.
     */
    public void describeCar() {
        System.out.println(
                doors + "-Door " + colour + " " + make + " " + model + " " + (convertible ? "convertible" : ""));
    }

    /**
     * 
     * @return the make of the car
     */
    public String getMake() {
        return make;
    }

    /**
     * @return the colour of the car
     */
    public String getColour() {
        return colour;
    }

    /**
     * @return the number of doors the car has
     */
    public int getDoors() {
        return doors;
    }

    /**
     * @return the model of the car
     */
    public String getModel() {
        return model;
    }

    /**
     * 
     * @return true if the car is a convertible, false otherwise
     */

    public boolean isConvertible() {
        return convertible;
    }

    /**
     * 
     * @param make the make to set
     */
    public void setMake(String make) {
        if (make == null) {

            this.make = "Unknown";
        } else {

            // this.make = make;
            String lowercaseMake = make.toLowerCase();
            switch (lowercaseMake) {
                case "holden", "porsche", "tesla" -> this.make = make;
                default -> this.make = "Unsupported";
            }
        }
    }

    /**
     * @param colour the colour to set
     */
    public void setColour(String colour) {
        this.colour = colour;
    }

    /**
     * @param convertible the convertible to set
     */
    public void setConvertible(boolean convertible) {
        this.convertible = convertible;
    }

    /**
     * @param doors the doors to set
     */
    public void setDoors(int doors) {
        this.doors = doors;
    }

    /**
     * @param model the model to set
     */
    public void setModel(String model) {
        this.model = model;
    }

}