package dev.ele;

public interface Mappable {
    GeoType getGeoType();

    static double[] stringToLatLon(String latLon) {
        String[] coords = latLon.strip().replace(" ", "").split(",");
        if (coords.length != 2) {
            throw new IllegalArgumentException("Cordinates should be a comma separated string of 2 doubles");
        }
        double lat = Double.valueOf(coords[0]);
        double lon = Double.valueOf(coords[1]);
        return new double[] { lat, lon };
    }

    void render();
}