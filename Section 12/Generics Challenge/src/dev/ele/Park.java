package dev.ele;

public class Park extends Point {

    private String name;
    private String type;

    public Park(String name, Coordinates coordinates) {
        this(name, "Park", coordinates);
    }

    public Park(String name, String coordinates) {
        this(name, "Park", coordinates);
    }

    public Park(String name, double lat, double lon) {
        this(name, "Park", lat, lon);
    }

    public Park(String name, String type, double lat, double lon) {
        super(lat, lon);
        this.name = name;
        this.type = type;
    }

    public Park(String name, String type, Coordinates coordinates) {
        super(coordinates);
        this.name = name;
        this.type = type;
    }

    public Park(String name, String type, String coordinates) {
        super(coordinates);
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return this.name;
    }

    public String getType() {
        return this.type;
    }

    @Override
    public void render() {
        System.out.printf("%s %s as %s (%s)", getName(), getType(), getGeoType(), getCoordinates());
    }
}