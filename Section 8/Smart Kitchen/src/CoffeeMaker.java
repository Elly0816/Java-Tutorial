public class CoffeeMaker extends Appliance {

    public CoffeeMaker() {
        super();
    }

    public void brewCoffee() {
        if (this.hasWorkToDo()) {
            System.out.println("Busy! " + this.getWorkBeingDone());
        } else {
            this.setHasWorkToDo(true);
            this.setWorkBeingDone("Brewing Coffee..");
        }
    }
}