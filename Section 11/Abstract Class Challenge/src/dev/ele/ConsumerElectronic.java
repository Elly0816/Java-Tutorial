package dev.ele;

public class ConsumerElectronic extends ProductForSale {

    private String manufacturer;
    private String model;

    public ConsumerElectronic(String manufacturer, String model, String type, double price, String description) {
        super(type, price, description);
        this.manufacturer = manufacturer;
        this.model = model;
    }

    @Override
    public void showDetails() {
        System.out.printf("MANUFACTURERS: %s%nMODEL: %s%nTYPE: %s%nPRICE: %s%nDESCRIPTION: %s%n", this.manufacturer,
                this.model, this.getType(), this.getPrice(), this.getDescription());

    }

    /**
     * @return the manufacturer
     */
    public String getManufacturer() {
        return manufacturer;
    }

    /**
     * @return the model
     */
    public String getModel() {
        return model;
    }

}