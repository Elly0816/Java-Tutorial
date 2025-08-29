import java.util.ArrayList;
import java.util.List;

public class Burger extends Item {

    private static final double basePrice = 8.5;

    // private String burgerType;
    // private int numberOfToppings;
    private List<Topping> toppings = new ArrayList<Topping>();

    public Burger(String burgerType, double price) {
        super(burgerType, price);
        // this.burgerType = burgerType;
    }

    public Burger(double price) {
        this(null, price);
    }

    public Burger() {
        this(null, basePrice);
    }

    public Burger(String burgerType) {
        this(burgerType, basePrice);
    }

    // Adds topping if there are less than sufficient toppings already
    protected void addTopping(Topping topping) {
        if (this.toppings.size() < this.getMaxNumberOfToppings()) {
            this.toppings.add(topping);
            this.addToppingPrice(topping);
            // this.numberOfToppings++;
            // System.out.printf("Topping added, you have %d toppings!%n", toppings.size());
        } else {
            // System.out.printf("Can't add more toppings!%nYou already have %d
            // toppings%n%n", this.toppings.size());
        }
    }

    protected void addToppingPrice(Topping topping) {
        this.addToPrice(topping.getPrice());
    }

    protected int getMaxNumberOfToppings() {
        return (this instanceof DeluxeBurger) ? 5 : 3;
    }

    /**
     * @return the burgerType
     */
    public String getBurgerType() {
        // return this.burgerType;
        return this.getType();
    }

    /**
     * @return the numberOfToppings
     */
    public int getNumberOfToppings() {
        // return numberOfToppings;
        return this.toppings.size();
    }

    /**
     * @return the toppings
     */
    public List<Topping> getToppings() {
        List<Topping> topping = new ArrayList<Topping>();
        for (int i = 0; i < this.toppings.size(); i++) {
            topping.add(this.toppings.get(i));
        }
        // System.out.println("This is the defensive copy of the toppings array: " +
        // topping.toString());
        return topping;
    }

    public double getBasePrice() {
        return basePrice;
    }

    @Override
    public String toString() {
        return super.toString() + "{" +
                " burgerType='" + getBurgerType() + "'" +
                ", numberOfToppings='" + getNumberOfToppings() + "'" +
                ", toppings='" + getToppings() + "'" +
                "}";
    }

    @Override
    public String getItemInfo() {
        StringBuilder toppingsInfo = new StringBuilder();
        for (int i = 0; i < this.getNumberOfToppings(); i++) {
            toppingsInfo.append("\t" + this.toppings.get(i).getItemInfo());
        }
        if (toppingsInfo.isEmpty()) {
            return String.format("""
                    %10s: %s = $%,.2f
                    """, "BURGER",
                    this.getClass().getSimpleName().toUpperCase(),
                    this.getBasePrice());
        } else {
            return String.format("""
                    %10s: %s = $%,.2f,%n%s
                    """, "BURGER",
                    this.getClass().getSimpleName().toUpperCase(),
                    this.getBasePrice(), toppingsInfo);

        }

    }

}