public class Main {

    public static void main(String[] args) {

        MealOrder mealItem = MealOrder.createMeal("Ham Burger", "Fanta", "Medium", "Fries", "Cheese", "Tomato",
                "Bacon");

        mealItem.addToppingToBurger("Pepperoni");
        mealItem.addToppingToBurger("Sausage");
        mealItem.addToppingToBurger("Omelette");

        System.out.println(mealItem);
        // mealItem.foodGreeting();

        // mealItem.printBurger();

        // mealItem.printDrink();

        // mealItem.printSide();

        mealItem.changeDrinkSize("Large");
        mealItem.printItemizedList();
        mealItem.printTotalAmount();
        // System.out.println(mealItem);
    }

}