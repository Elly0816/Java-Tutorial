package dev.ele;

public class Park extends Point {

    private String name;
    private String type;
    private static final String DEFAULT_TYPE = "Park";

    public Park(String name, Coordinates coordinates) {
        super(coordinates);
        this.name = name;
        this.type = DEFAULT_TYPE;
    }

    public Park(String name, String coordinates) {
        super(coordinates);
        this.name = name;
        this.type = DEFAULT_TYPE;
    }

    public Park(String name, double lat, double lon) {
        super(lat, lon);
        this.name = name;
        this.type = DEFAULT_TYPE;
    }

    public Park(String name, String type, double lat, double lon) {
        this(name, lat, lon);
        this.type = type;
    }

    public Park(String name, String type, Coordinates coordinates) {
        this(name, coordinates);
        this.type = type;
    }

    public Park(String name, String type, String coordinates) {
        this(name, coordinates);
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return name + " " + type;
    }

    @Override
    public void render() {
        System.out.printf("Render %s as %s (%s)", this, getGeoType(), getCoordinates());
    }
}