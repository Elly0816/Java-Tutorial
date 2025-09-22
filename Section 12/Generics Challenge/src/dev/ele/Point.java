package dev.ele;

public abstract class Point implements Mappable {

    private final Coordinates coordinates;

    public Point(Coordinates coordinates) {
        if (coordinates == null) {
            throw new IllegalArgumentException("Enter a non null value");
        }
        this.coordinates = coordinates;
    }

    public Point(double lat, double lon) {
        this(new Coordinates(lat, lon));

    }

    public Point(String coordinates) {
        if (coordinates.isBlank() || coordinates == null) {
            throw new IllegalArgumentException("Enter a non null or non empty value");
        }
        double[] latLon = Mappable.stringToLatLon(coordinates);
        this.coordinates = new Coordinates(latLon[0], latLon[1]);
    }

    public Coordinates getCoordinates() {
        return this.coordinates;
    }

    @Override
    public GeoType getGeoType() {
        return GeoType.POINT;
    }

}