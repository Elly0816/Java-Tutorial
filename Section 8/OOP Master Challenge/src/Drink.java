/***
 * 
 * The drink inherits from the Meal
 */

public class Drink extends Item {
    private String size;

    public Drink(String type, String size) {
        this(type, size, 0);
    }

    public Drink(String type, String size, double price) {

        super(type, getPriceFromSize(size, price));
        this.size = size;
    }

    /**
     * @return the size
     */
    public String getSize() {
        return size;
    }

    @Override
    public String toString() {
        return super.toString() + "{" +
                " size='" + getSize() + "'" +
                "}";
    }

    private static double getPriceFromSize(String size, double price) {
        if (size == null || size.trim().isBlank())
            return price;
        return switch (size.toLowerCase().charAt(0)) {// The price of the drink is determined by it's size
            case 'm' -> 1.00;
            case 'l' -> 1.5;
            case 's' -> 0.5;
            default -> price;
        };
    }

    @Override
    public String getItemInfo() {
        return String.format("""
                %10s: %s %s = $%,.2f
                """, this.getClass().getSimpleName().toUpperCase(), this.getSize().toUpperCase(),
                this.getType().toUpperCase(),
                this.getPrice());
    }

}