/**
 * This file contains the Meal class
 * 
 * It is the parent to all Meal items
 * 
 * 
 */

public class Item {
    private String type;
    private double price;

    public Item(String type, double price) {
        this.type = type;
        if (price < 0) {
            this.price = 0;
        } else {
            this.price = price;
        }
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    protected void addToPrice(double price) {
        this.price += price;
    }

    @Override
    public String toString() {
        return "{" +
                " type='" + getType() + "'" +
                ", price='" + getPrice() + "'" +
                "}";
    }

}