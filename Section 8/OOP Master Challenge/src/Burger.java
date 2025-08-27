import java.util.ArrayList;
import java.util.List;

public class Burger extends Meal {

    private String burgerType;
    private int numberOfToppings;
    private List<Topping> toppings = new ArrayList<Topping>();

    public Burger(String burgerType, double price) {
        super("Burger", price);
        this.burgerType = burgerType;
    }

    public Burger(double price) {
        this(null, price);
    }

    // Adds topping if there are less than 3 toppings already
    protected void addTopping(Topping topping) {
        if (toppings.size() < this.getMaxNumberOfToppings()) {
            toppings.add(topping);
            this.addToppingPrice(topping);
            this.numberOfToppings++;
            System.out.printf("Topping added, you have %d toppings!%n", toppings.size());
        } else {
            System.out.printf("Can't add more toppings!%nYou already have %d toppings%n%n", this.toppings.size());
        }
    }

    protected void addToppingPrice(Topping topping) {
        this.addToPrice(topping.getPrice());
    }

    protected int getMaxNumberOfToppings() {
        return 3;
    }

    /**
     * @return the burgerType
     */
    public String getBurgerType() {
        return burgerType;
    }

    /**
     * @return the numberOfToppings
     */
    public int getNumberOfToppings() {
        return numberOfToppings;
    }

    /**
     * @return the toppings
     */
    public List<Topping> getToppings() {
        return toppings;
    }

    @Override
    public String toString() {
        return super.toString() + "{" +
                " burgerType='" + getBurgerType() + "'" +
                ", numberOfToppings='" + getNumberOfToppings() + "'" +
                ", toppings='" + getToppings() + "'" +
                "}";
    }

}