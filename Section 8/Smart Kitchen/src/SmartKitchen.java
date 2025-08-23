public class SmartKitchen {

    private CoffeeMaker brewMaster;
    private DishWasher dishwasher;
    private Refrigerator iceBox;

    public SmartKitchen() {
        this.brewMaster = new CoffeeMaker();
        this.dishwasher = new DishWasher();
        this.iceBox = new Refrigerator();
    }

    // public SmartKitchen(CoffeeMaker coffeeMaker, DishWasher dishWasher,
    // Refrigerator refrigerator) {
    // this.brewMaster = coffeeMaker;
    // this.dishwasher = dishWasher;
    // this.iceBox = refrigerator;
    // }

    public void addWater() {
        if (this.brewMaster.hasWorkToDo()) {
            this.printWorkBeingDone(this.brewMaster, "Brew-master");
        } else {

            this.brewMaster.setHasWorkToDo(true);
            this.brewMaster.setWorkBeingDone("Adding water");
        }
    }

    public void pourMilk() {
        if (this.iceBox.hasWorkToDo()) {
            this.printWorkBeingDone(this.iceBox, "Ice-box");
        } else {
            this.iceBox.setHasWorkToDo(true);
            this.iceBox.setWorkBeingDone("Pouring Milk");
        }
    }

    public void loadDishwasher() {
        if (this.dishwasher.hasWorkToDo()) {
            this.printWorkBeingDone(this.dishwasher, "dishwasher");
        } else {
            this.dishwasher.setHasWorkToDo(true);
            this.dishwasher.setWorkBeingDone("Loading Dishwasher");
        }
    }

    public void setKitchenState(boolean brewMasterState, boolean dishWasherState, boolean refrigeratorState) {
        this.dishwasher.setHasWorkToDo(dishWasherState);
        if (dishWasherState) {
            this.dishwasher.setWorkBeingDone("Something");
        }
        this.brewMaster.setHasWorkToDo(brewMasterState);
        if (brewMasterState) {
            this.brewMaster.setWorkBeingDone("Something");
        }
        this.iceBox.setHasWorkToDo(refrigeratorState);
        if (refrigeratorState) {
            this.iceBox.setWorkBeingDone("Something");
        }
    }

    private void printWorkBeingDone(Appliance app, String applianceName) {
        System.out.println(app.getWorkBeingDone(applianceName));
    }

    public void printWorkBeingDoneByCoffeeMaker() {
        this.printWorkBeingDone(brewMaster, "Brew Master");
    }

    public void printWorkBeingDoneByDishWasher() {
        this.printWorkBeingDone(dishwasher, "Dish Washer");
    }

    public void printWorkBeingDoneByIceBox() {
        this.printWorkBeingDone(iceBox, "Ice box");
    }

    public void doKitchenWork() {
        this.dishwasher.doDishes();
        this.iceBox.orderFood();
        this.brewMaster.brewCoffee();
    }

    /**
     * @return the brewMaster
     */
    // public CoffeeMaker getBrewMaster() {
    // return brewMaster;
    // }

    // /**
    // * @return the dishwasher
    // */
    // public DishWasher getDishwasher() {
    // return dishwasher;
    // }

    // /**
    // * @return the iceBox
    // */
    // public Refrigerator getIceBox() {
    // return iceBox;
    // }

}