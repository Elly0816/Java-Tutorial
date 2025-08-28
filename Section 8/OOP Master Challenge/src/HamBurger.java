/***
 * 
 * 
 * 
 * This class overrides the getBasePRice emthod on it's parent.
 * 
 */

public class HamBurger extends Burger {

    private static final double basePrice = 10.5;
    private static final String type = "Hamburger";

    public HamBurger(double price) {
        super(type, price);
    }

    public HamBurger() {
        this(basePrice);
    }

    @Override
    public double getBasePrice() {
        return basePrice;
    }
}