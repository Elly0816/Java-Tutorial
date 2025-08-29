public class Main {

    public static void main(String[] args) {

        MealOrder mealItem = MealOrder.createMeal("Deluxe Burger", "Fanta", "Medium", "Fries", "Cheese", "Tomato",
                "Bacon");

        mealItem.addToppingToBurger("Pepperoni");
        mealItem.addToppingToBurger("Sausage");
        mealItem.addToppingToBurger("Omelette");

        // System.out.println(mealItem);
        // mealItem.foodGreeting();

        // mealItem.printBurger();

        // mealItem.printDrink();

        // mealItem.printSide();

        mealItem.printItemizedList();
        mealItem.changeDrinkSize("Large");
        // mealItem.printTotalAmount();
        // System.out.println(mealItem);
    }

}