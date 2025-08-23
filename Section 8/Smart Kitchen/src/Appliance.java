public class Appliance {
    private boolean hasWorkToDo;
    private StringBuilder workBeingDone;

    public Appliance() {
        this.hasWorkToDo = false;
        this.workBeingDone = new StringBuilder("Doing Nothing");
    }

    public String getWorkBeingDone() {
        return String.format("The appliance is currently %s", this.workBeingDone.toString().toLowerCase());
    }

    public String getWorkBeingDone(String applianceName) {
        return String.format("The %s is currently %s", applianceName, this.workBeingDone.toString().toLowerCase());
    }

    public void setWorkBeingDone(String workBeingDone) {
        this.workBeingDone = new StringBuilder(workBeingDone);
    }

    public boolean hasWorkToDo() {
        return this.hasWorkToDo;
    }

    public void setHasWorkToDo(boolean hasWorkToDo) {
        this.hasWorkToDo = hasWorkToDo;
        if (!hasWorkToDo) {
            this.setWorkBeingDone("Doing Nothing");
        }
    }
}
