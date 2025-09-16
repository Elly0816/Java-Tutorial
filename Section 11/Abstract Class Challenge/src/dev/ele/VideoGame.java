package dev.ele;

public class VideoGame extends ProductForSale {
    String manufacturer;
    String genre;
    boolean isAdult;
    Platform platform;

    public VideoGame(String manufacturer, String genre, boolean isAdult, Platform platform, String type, double price,
            String description) {
        super(type, price, description);
        this.manufacturer = manufacturer;
        this.genre = genre;
        this.isAdult = isAdult;
        this.platform = platform;
    }

    @Override
    public void showDetails() {
        String isAdultString = isAdult ? "contains explicit content" : "does not contain explicit content";
        System.out.printf(
                "TYPE: %s%nPRICE: %s%nMANUFACTURER: %s%nADULT ONLY: %s%nGENRE: %s%nPLATFORM: %s%nDESCRIPTION: %s%n",
                this.getType(), this.getPrice(), this.manufacturer, isAdultString,
                this.genre, this.platform, this.getDescription());

    }

    /**
     * @return the platform
     */
    public Platform getPlatform() {
        return platform;
    }

    /**
     * @return the manufacturer
     */
    public String getManufacturer() {
        return manufacturer;
    }

    /**
     * @return the genre
     */
    public String getGenre() {
        return genre;
    }

    /**
     * @return the isAdult
     */
    public boolean isAdult() {
        return isAdult;
    }
}