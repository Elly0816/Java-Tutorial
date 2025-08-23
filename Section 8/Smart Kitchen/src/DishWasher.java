public class DishWasher extends Appliance {

    public DishWasher() {
        super();
    }

    public void doDishes() {
        if (this.hasWorkToDo()) {
            System.out.println("Busy! " + this.getWorkBeingDone());
        } else {
            this.setWorkBeingDone("Doing Dishes");
            this.setHasWorkToDo(true);
        }
    }
}