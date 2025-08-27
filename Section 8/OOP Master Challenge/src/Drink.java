/***
 * 
 * The drink inherits from the Meal
 */

public class Drink extends Meal {
    private String size;

    public Drink(String type, String size, double price) {
        super(type, switch (size.toLowerCase().charAt(0)) {// The price of the drink is determined by it's size
            case 'm' -> 1.00;
            case 'l' -> 1.5;
            case 's' -> 0.5;
            default -> 0.5;
        });
        this.size = size;
    }

    /**
     * @return the size
     */
    public String getSize() {
        return size;
    }

    @Override
    public String toString() {
        return super.toString() + "{" +
                " size='" + getSize() + "'" +
                "}";
    }

}