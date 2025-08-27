/**
 * The deluxe burger can have 5 toppings
 * 
 * The toppings should not change the original price of the burger
 * 
 * 
 */
public class DeluxeBurger extends Burger {

    public DeluxeBurger(double price) {
        super("Deluxe Burger", price);
    }

    @Override
    protected int getMaxNumberOfToppings() {
        return 5;
    }

    @Override
    protected void addToppingPrice(Topping topping) {
        this.addToPrice(0);
    }

}