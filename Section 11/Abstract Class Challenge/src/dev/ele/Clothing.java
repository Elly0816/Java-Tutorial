package dev.ele;

public class Clothing extends ProductForSale {

    private String manufacturers;
    private int yearOfManufacture;
    private OccasionType occassion;
    private Size size;

    public Clothing(String manufacturers, int yearOfManufacture, OccasionType occasion, Size size, String type,
            double price, String description) {
        super(type, price, description);
        this.manufacturers = manufacturers;
        this.yearOfManufacture = yearOfManufacture;
        this.occassion = occasion;
        this.size = size;

    }

    @Override
    public void showDetails() {
        System.out.printf(
                "MANUFACTURERS: %s%nMAKE YEAR: %s%nTYPE: %s%nPRICE: %s%nOCCASION: %s%nSIZE: %s%nDESCRIPTION: %s%n",
                this.manufacturers,
                this.yearOfManufacture, this.getType(), this.getPrice(), this.occassion.name(), this.size.name(),
                this.getDescription());

    }

    /**
     * @return the manufacturers
     */
    public String getManufacturers() {
        return manufacturers;
    }

    /**
     * @return the yearOfManufacture
     */
    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    /**
     * @return the occassion
     */
    public OccasionType getOccassion() {
        return occassion;
    }

    /**
     * @return the size
     */
    public Size getSize() {
        return size;
    }
}