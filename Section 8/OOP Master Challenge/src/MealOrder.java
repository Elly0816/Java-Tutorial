/**
 * 
 * This controls the creation of MealOrders
 */

public class MealOrder {
    private Burger burger;
    private Drink drink;
    private Side side;

    public MealOrder() {
        this.burger = new Burger(null, 0);
        this.drink = new Drink(null, "small");
        this.side = new Side(null);
    }

    public MealOrder(Burger burger, Drink drink, Side side) {
        this.burger = burger;
        this.drink = drink;
        this.side = side;
    }

    // Overloaded methods to create and return a new meal order
    public static MealOrder createMeal(String burgerType, String drinkType, String drinkSize, String sideType) {
        Burger burger;
        if (burgerType == null || burgerType.trim().isBlank()) {
            burger = new Burger();
        } else {
            burger = switch (burgerType.toLowerCase().charAt(0)) {
                case 'd' -> new DeluxeBurger();
                case 'h' -> new HamBurger();
                default -> new Burger();
            };
        }

        Drink drink = new Drink(drinkType, drinkSize);

        Side side = new Side(sideType);

        return new MealOrder(burger, drink, side);
    }

    public static MealOrder createMeal(String burgerType, String drinkType, String drinkSize, String sideType,
            String topping1) {
        MealOrder meal = createMeal(burgerType, drinkType, drinkSize, sideType);
        return meal.getBurgerAndAddTopping(topping1);

    }

    public static MealOrder createMeal(String burgerType, String drinkType, String drinkSize, String sideType,
            String topping1, String topping2) {

        MealOrder meal = createMeal(burgerType, drinkType, drinkSize, sideType, topping1);
        return meal.getBurgerAndAddTopping(topping2);
    }

    public static MealOrder createMeal(String burgerType, String drinkType, String drinkSize, String sideType,
            String topping1, String topping2, String topping3) {
        MealOrder meal = createMeal(burgerType, drinkType, drinkSize, sideType, topping1, topping2);
        return meal.getBurgerAndAddTopping(topping3);
    }

    // Overloaded method that changes the size of the drink
    public void changeDrinkSize(String size) {
        Drink newDrink = new Drink(this.getDrink().getType(), size);
        this.drink = newDrink;
    }

    public void ChangeDrinkSize(String type, String size) {
        Drink newDrink = new Drink(type, size);
        this.drink = newDrink;
    }

    /**
     * prints the burger to the console
     */
    public void printBurger() {
        System.out.println(this.burger);
    }

    /**
     * prints the drink to the console
     */
    public void printDrink() {
        System.out.println(this.drink);
        // return drink;
    }

    /**
     * prints the side to the console
     */
    public void printSide() {
        System.out.println(this.side);
        // return side;
    }

    /**
     * @return the burger
     */
    private Burger getBurger() {
        return burger;
    }

    /**
     * @return the drink
     */
    private Drink getDrink() {
        return drink;
    }

    /**
     * @return the side
     */
    private Side getSide() {
        return side;
    }

    // Overloaded method for adding toppings to burgers
    public void addToppingToBurger(String topping) {
        this.burger.addTopping(new Topping(topping));
    }

    public void addToppingToBurger(String topping, double price) {
        this.burger.addTopping(new Topping(topping, price));
    }

    @Override
    public String toString() {
        return "{" +
                " burger='" + getBurger() + "'" +
                ", drink='" + getDrink() + "'" +
                ", side='" + getSide() + "'" +
                "}";
    }

    public void printItemizedList() {
        System.out.printf(
                "%s's base price=%,.2f,\nYour %,d toppings are: %s\nYour drink %s %s is %,.2f\nAnd your side %s is %,.2f",
                this.getBurger().getClass().getSimpleName(),
                this.getBurger().getBasePrice(), this.getBurger().getNumberOfToppings(),
                this.getBurger().getToppings(), this.getDrink().getSize(), this.getDrink().getType(),
                this.getDrink().getPrice(), this.getSide().getType(), this.getSide().getPrice());
    }

    public void printTotalAmount() {
        double totalAmount = this.getBurger().getPrice() + this.getSide().getPrice() + this.getDrink().getPrice();
        System.out.printf("%nThe total amount due for this meal is %,.2f", totalAmount);
    }

    private MealOrder getBurgerAndAddTopping(String topping) {
        Burger burger = this.getBurger();
        burger.addTopping(new Topping(topping));

        return this;
    }

    // public void foodGreeting() {
    // if (this.getBurger() instanceof DeluxeBurger db) {
    // System.out.printf("%s!%nUp to 5 toppings with no price increase on the deluxe
    // burger meal!",
    // db.getClass().getSimpleName());
    // } else if (this.getBurger() instanceof HamBurger hb) {
    // System.out.printf("%s!%nUp to 3 toppings with price increases of course on
    // the ham burger meal!",
    // hb.getClass().getSimpleName());
    // } else {
    // System.out.printf("%s!%nUp to 3 toppings with price increases of course on
    // the burger meal!",
    // this.getBurger().getClass().getSimpleName());
    // }
    // System.out.println("");
    // }

}