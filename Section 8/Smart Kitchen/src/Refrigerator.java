public class Refrigerator extends Appliance {

    public Refrigerator() {
        super();
    }

    public void orderFood() {
        if (this.hasWorkToDo()) {
            System.out.println("Busy! " + this.getWorkBeingDone());
        } else {
            this.setWorkBeingDone("Ordering Food...");
            this.setHasWorkToDo(true);
        }
    }
}