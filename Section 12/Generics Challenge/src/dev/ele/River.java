package dev.ele;

public class River extends Line {

    private String name;
    private String type;
    private static final String DEFAULT_TYPE = "River";

    public River(String name, LineCoordinates coordinates) {
        super(coordinates);
        this.name = name;
        this.type = DEFAULT_TYPE;
    }

    public River(String name, String... coordinates) {
        super(coordinates);
        this.name = name;
        this.type = DEFAULT_TYPE;
    }

    public River(String name, double[]... coordinates) {
        super(coordinates);
        this.name = name;
        this.type = DEFAULT_TYPE;
    }

    public River(String name, String type, LineCoordinates coordinates) {
        this(name, coordinates);
        this.type = type;
    }

    // public River(String name, String type, String... coordinates) {
    // this(name, coordinates);
    // this.type = type;
    // }

    public River(String name, String type, double[]... coordinates) {
        this(name, coordinates);
        this.type = type;
    }

    public String getName() {
        return this.name;
    }

    public String getType() {
        return this.type;
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