public class Product {

    private String model;
    private String manufacturer;
    private int width;
    private int height;
    private int depth;

    public Product(String model, String manufacturer) {
        this.model = model;
        this.manufacturer = manufacturer;
    }

    public Product(String model, String manufacturer, int width, int height, int depth) {
        this(model, manufacturer);
        this.height = height;
        this.width = width;
        this.depth = depth;
        if (height < 0) {
            this.height = 0;
        }
        if (width < 0) {
            this.width = 0;
        }
        if (depth < 0) {
            this.depth = 0;
        }
    }

    /**
     * @return the depth
     */
    public int getDepth() {
        return depth;
    }

    /**
     * @return the height
     */
    public int getHeight() {
        return height;
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

    /**
     * @return the width
     */
    public int getWidth() {
        return width;
    }

    /**
     * @param depth the depth to set
     */
    public void setDepth(int depth) {
        this.depth = depth;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * @param width the width to set
     */
    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public String toString() {
        return "{" +
                " model='" + getModel() + "'" +
                ", manufacturer='" + getManufacturer() + "'" +
                ", width='" + getWidth() + "'" +
                ", height='" + getHeight() + "'" +
                ", depth='" + getDepth() + "'" +
                "}";
    }

}

class Monitor extends Product {

    private int size;
    private String resolution;

    public Monitor(String model, String manufacturer) {
        super(model, manufacturer);
    }

    public Monitor(String model, String manufacturer, String resolution, int size) {
        this(model, manufacturer);
        this.resolution = resolution;
        this.size = size;
        if (size < 0) {
            this.size = 0;
        }
    }

    public void drawPixelAt(int x, int y, String color) {
        System.out.printf("Drew %s pixel at (%d, %d)%n", color, x, y);
        return;
    }

    /**
     * @return the resolution
     */
    public String getResolution() {
        return resolution;
    }

    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "{" +
                " size='" + getSize() + "'" +
                ", resolution='" + getResolution() + "'" +
                "}" + super.toString();
    }

    /**
     * @param size the size to set
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * @param resolution the resolution to set
     */
    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

}

class Motherboard extends Product {

    private int ramSlots;
    private int cardSlots;
    private String bios;

    public Motherboard(String model, String manufacturer) {
        super(model, manufacturer);
    }

    public Motherboard(String model, String manufacturer, String bios, int ramSlots, int cardSlots) {
        this(model, manufacturer);
        this.bios = bios;
        this.ramSlots = ramSlots;
        this.cardSlots = cardSlots;
        if (ramSlots < 0) {
            this.ramSlots = 0;
        }
        if (cardSlots < 0) {
            this.cardSlots = 0;
        }
    }

    public void loadProgram(String programName) {
        System.out.printf("Loading %s", programName);
        return;
    }

    /**
     * @return the bios
     */
    public String getBios() {
        return bios;
    }

    /**
     * @return the cardSlots
     */
    public int getCardSlots() {
        return cardSlots;
    }

    /**
     * @return the ramSlots
     */
    public int getRamSlots() {
        return ramSlots;
    }

    @Override
    public String toString() {
        return "{" +
                " ramSlots='" + getRamSlots() + "'" +
                ", cardSlots='" + getCardSlots() + "'" +
                ", bios='" + getBios() + "'" +
                "}" + super.toString();
    }

    /**
     * @param bios the bios to set
     */
    public void setBios(String bios) {
        this.bios = bios;
    }

    /**
     * @param cardSlots the cardSlots to set
     */
    public void setCardSlots(int cardSlots) {
        this.cardSlots = cardSlots;
    }

    /**
     * @param ramSlots the ramSlots to set
     */
    public void setRamSlots(int ramSlots) {
        this.ramSlots = ramSlots;
    }

}

class ComputerCase extends Product {

    private String powerSupply;

    public ComputerCase(String model, String manufacturer) {
        super(model, manufacturer);
    }

    public ComputerCase(String model, String manufacturer, String powerSupply) {
        this(model, manufacturer);
        this.powerSupply = powerSupply;
    }

    public void pressPowerButton() {
        System.out.println("The power button was just pressed");
        return;
    }

    /**
     * @return the powerSupply
     */
    public String getPowerSupply() {
        return powerSupply;
    }

    @Override
    public String toString() {
        return "{" +
                " powerSupply='" + getPowerSupply() + "'" +
                "}" + super.toString();
    }

    /**
     * @param powerSupply the powerSupply to set
     */
    public void setPowerSupply(String powerSupply) {
        this.powerSupply = powerSupply;
    }

}
