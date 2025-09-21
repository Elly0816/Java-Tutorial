package dev.ele;

public class River extends Line {

    private String name;
    private String type;

    public River(String name, LineCoordinates coordinates) {
        this(name, "River", coordinates);
    }

    public River(String name, String... coordinates) {
        super(coordinates);
        this.name = name;
        this.type = "River";
    }

    public River(String name, double[]... coordinates) {
        this(name, "River", coordinates);
    }

    public River(String name, String type, LineCoordinates coordinates) {
        super(coordinates);
        this.name = name;
        this.type = type;
    }

    // public River(String name, String type, String... coordinates) {
    // super(coordinates);
    // this.name = name;
    // this.type = type;
    // }

    public River(String name, String type, double[]... coordinates) {
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