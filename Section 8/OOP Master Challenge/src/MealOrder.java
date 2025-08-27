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
        this.drink = new Drink(null, null, 0);
        this.side = new Side(null, 0);
    }

    public MealOrder(Burger burger, Drink drink, Side side) {
        this.burger = burger;
        this.drink = drink;
        this.side = side;
    }

    public static MealOrder createMeal(String burgerType, String drinkType, String drinkSize, String sideType) {
        Burger burger = switch (burgerType.toLowerCase().charAt(0)) {
            case 'd' -> new DeluxeBurger(0);
            case 'h' -> new HamBurger(0);
            default -> new Burger(0);
        };

        Drink drink = new Drink(drinkType, drinkSize, 0);

        Side side = new Side(sideType, 0);

        return new MealOrder(burger, drink, side);
    }

    public static MealOrder createMeal(String burgerType, String drinkType, String drinkSize, String sideType,
            String topping1) {
        Burger burger = switch (burgerType.toLowerCase().charAt(0)) {
            case 'd' -> new DeluxeBurger(0);
            case 'h' -> new HamBurger(0);
            default -> new Burger(0);
        };

        burger.addTopping(new Topping(topping1, 0));

        Drink drink = new Drink(drinkType, drinkSize, 0);

        Side side = new Side(sideType, 0);

        return new MealOrder(burger, drink, side);
    }

    public static MealOrder createMeal(String burgerType, String drinkType, String drinkSize, String sideType,
            String topping1, String topping2) {
        Burger burger = switch (burgerType.toLowerCase().charAt(0)) {
            case 'd' -> new DeluxeBurger(0);
            case 'h' -> new HamBurger(0);
            default -> new Burger(0);
        };

        burger.addTopping(new Topping(topping1, 0));
        burger.addTopping(new Topping(topping2, 0));

        Drink drink = new Drink(drinkType, drinkSize, 0);

        Side side = new Side(sideType, 0);

        return new MealOrder(burger, drink, side);
    }

    public static MealOrder createMeal(String burgerType, String drinkType, String drinkSize, String sideType,
            String topping1, String topping2, String topping3) {
        Burger burger = switch (burgerType.toLowerCase().charAt(0)) {
            case 'd' -> new DeluxeBurger(0);
            case 'h' -> new HamBurger(0);
            default -> new Burger(0);
        };
        burger.addTopping(new Topping(topping1, 0));
        burger.addTopping(new Topping(topping2, 0));
        burger.addTopping(new Topping(topping3, 0));

        Drink drink = new Drink(drinkType, drinkSize, 0);

        Side side = new Side(sideType, 0);

        return new MealOrder(burger, drink, side);
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
        System.out.println(this.drink);
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

    public void addToppingToBurger(String topping) {
        this.burger.addTopping(new Topping(topping, 0));
    }

    @Override
    public String toString() {
        return "{" +
                " burger='" + getBurger() + "'" +
                ", drink='" + getDrink() + "'" +
                ", side='" + getSide() + "'" +
                "}";
    }

}