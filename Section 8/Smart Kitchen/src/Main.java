public class Main {

    public static void main(String[] args) {
        // CoffeeMaker coffeeMaker = new CoffeeMaker();
        // DishWasher dishWasher = new DishWasher();
        // Refrigerator refrigerator = new Refrigerator();
        // SmartKitchen smartKitchen = new SmartKitchen(coffeeMaker, dishWasher,
        // refrigerator);

        SmartKitchen smartKitchen = new SmartKitchen();
        smartKitchen.addWater();
        smartKitchen.loadDishwasher();
        smartKitchen.pourMilk();
        smartKitchen.printWorkBeingDoneByIceBox();
        smartKitchen.printWorkBeingDoneByDishWasher();
        smartKitchen.printWorkBeingDoneByCoffeeMaker();
        // smartKitchen.getDishwasher().doDishes();
        smartKitchen.setKitchenState(false, false,
                false);
        // smartKitchen.getDishwasher().doDishes();
        smartKitchen.printWorkBeingDoneByDishWasher();
        smartKitchen.printWorkBeingDoneByCoffeeMaker();
        smartKitchen.printWorkBeingDoneByIceBox();
        smartKitchen.setKitchenState(false, false, false);
        smartKitchen.printWorkBeingDoneByDishWasher();
        smartKitchen.printWorkBeingDoneByCoffeeMaker();
        smartKitchen.printWorkBeingDoneByIceBox();
        smartKitchen.doKitchenWork();
        smartKitchen.printWorkBeingDoneByDishWasher();
        smartKitchen.printWorkBeingDoneByCoffeeMaker();
        smartKitchen.printWorkBeingDoneByIceBox();

    }
}