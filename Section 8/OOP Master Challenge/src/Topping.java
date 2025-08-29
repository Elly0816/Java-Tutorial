public class Topping extends Item {

    public Topping(String type, double price) {
        super(type, price);
    }

    public Topping(String type) {
        this(type, 0.25);
    }
}