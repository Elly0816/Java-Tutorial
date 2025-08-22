public class Fish extends Animal {

    private int fins;
    private int gills;

    public Fish() {
        this(8, 4, 2);
    }

    public Fish(double weight, int fins, int gills) {
        this("Fish", weight, fins, gills);
    }

    public Fish(String type, double weight, int fins, int gills) {
        this(type, weight < 5 ? "Small" : weight > 15 ? "Large" : "Medium", weight, fins, gills);
    }

    public Fish(String type, String size, double weight, int fins, int gills) {
        super(type, size, weight);
        this.fins = fins;
        this.gills = gills;
    }

    /**
     * @return the fins
     */
    public int getFins() {
        return fins;
    }

    /**
     * @return the gills
     */
    public int getGills() {
        return gills;
    }

    private void moveMuscles() {
        System.out.println("Muscles moving ");
    }

    private void moveBackFins() {
        System.out.println("Back fin moving ");

    }

    @Override
    public void move(String speed) {
        if (speed.toLowerCase().equals("fast")) {
            System.out.println("Goldfish moves fast");
            this.moveBackFins();
        }
        System.out.println();
        this.moveMuscles();
    }

    @Override
    public String toString() {
        return "{" +
                " fins='" + getFins() + "'" +
                ", gills='" + getGills() + "'" +
                "}" + super.toString();
    }

}