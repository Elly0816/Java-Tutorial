public class Side extends Item {

    public Side(String type, double price) {
        super(type, price);
    }

    public Side(String type) {
        this(type, 0.5);
    }

}