/**
 * The deluxe burger can have 5 toppings
 * 
 * The toppings should not change the original price of the burger
 * 
 * 
 */
public class DeluxeBurger extends Burger {

    private static final String type = "Deluxe Burger";
    private static final double basePrice = 12.5;

    public DeluxeBurger(double price) {
        super(type, price);
    }

    public DeluxeBurger() {
        this(basePrice);
    }

    @Override
    protected int getMaxNumberOfToppings() {
        return 5;
    }

    @Override
    protected void addToppingPrice(Topping topping) {
        this.addToPrice(0);
    }

    @Override
    public double getBasePrice() {
        return basePrice;
    }

}