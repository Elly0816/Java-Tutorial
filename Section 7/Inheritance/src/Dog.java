public class Dog extends Animal {

    private String earShape;
    private String tailShape;

    public Dog() {
        this("Mutt", 50, null, null);
    }

    public Dog(String type, double weight) {
        this(type, weight, "Perky", "Curled");
    }

    public Dog(String type, double weight, String earShape, String tailShape) {
        super(type, weight < 15 ? "Small" : weight < 35 ? "Medium" : "Large", weight);
        this.earShape = earShape;
        this.tailShape = tailShape;
    }

    /**
     * @return the earShape
     */
    public String getEarShape() {
        return earShape;
    }

    /**
     * @return the tailShape
     */
    public String getTailShape() {
        return tailShape;
    }

    private void run() {
        // super.move("fast");
        System.out.print("Dog running ");
    }

    private void walk() {
        // super.move("slow");
        System.out.print("Dog walking ");
    }

    public void wagTail() {

        System.out.println("Dog wags tail! ");
    }

    private void bark() {
        System.out.print("Woof! ");
    }

    @Override
    public void makeNoise() {
        if (type.toLowerCase().equals("wolf")) {
            System.out.println("Ow Wooo!");
        }
        this.bark();
        System.out.println();
    }

    @Override
    public void move(String speed) {
        if (speed.toLowerCase().contains("slow")) {
            this.walk();
            wagTail();
        }

        if (speed.toLowerCase().contains("fast")) {
            this.run();
            this.bark();
        }
        System.out.println();

        // super.move(speed);
        // System.out.println("Dogs walk, run and wag their tail");

    }

    @Override
    public String toString() {
        return "{" +
                " earShape='" + getEarShape() + "'" +
                ", tailShape='" + getTailShape() + "'" +
                "}" + super.toString();
    }

    // @Override
    // public String toString() {
    // return "{" +
    // " type='" + getType() + "'" +
    // ", size='" + getSize() + "'" +
    // ", weight='" + getWeight() + "'" +
    // " earShape='" + getEarShape() + "'" +
    // ", tailShape='" + getTailShape() + "'" +
    // "}";
    // }

}