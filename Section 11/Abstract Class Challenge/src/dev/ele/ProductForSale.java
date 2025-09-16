package dev.ele;

public abstract class ProductForSale {
    private String type;
    private double price;
    private String description;

    public ProductForSale(String type, double price, String description) {
        this.type = type;
        this.price = price;
        this.description = description;
    }

    public double getSalesPrice(int quantity) {
        return quantity * this.price;
    }

    public void printPricedItem(int quantity) {
        System.out.printf("ITEM: %s%nPRICE: %.2f%nQUANTITY: %d%nTOTAL:%.2f%n", this.type, this.price,
                quantity, this.getSalesPrice(quantity));
    }

    public abstract void showDetails();

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

}