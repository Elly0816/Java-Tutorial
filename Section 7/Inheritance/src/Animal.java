public class Animal {

    protected String type;
    private String size;
    private double weight;

    public Animal(String type, String size, double weight) {
        this.type = type;
        this.size = size;
        this.weight = weight;
    }

    /**
     * @return the size
     */
    public String getSize() {
        return size;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @return the weight
     */
    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "{" +
                " type='" + getType() + "'" +
                ", size='" + getSize() + "'" +
                ", weight='" + getWeight() + "'" +
                "}";
    }

    public void move(String speed) {
        System.out.println(type + " moves " + speed);
    }

    public void makeNoise() {
        System.out.println(type + " makes some kind of noise!");
    }
}