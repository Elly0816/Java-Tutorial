package dev.ele;

import java.util.ArrayList;
import java.util.List;

public abstract class Line implements Mappable {

    private final LineCoordinates coordinates;

    public Line(LineCoordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Line(String... coordinates) {
        if (coordinates.length < 2) {
            throw new IllegalArgumentException("A line takes at least 2 coordinate pairs!");
        }
        List<String> coords = List.of(coordinates);
        List<double[]> latsAndLongs = new ArrayList<>();
        for (String c : coords) {
            latsAndLongs.add(Mappable.stringToLatLon(c));
        }
        List<Coordinates> coordList = new ArrayList<>();
        for (int i = 0; i < latsAndLongs.size(); i++) {
            coordList.add(new Coordinates(latsAndLongs.get(i)[0], latsAndLongs.get(i)[1]));
        }
        this.coordinates = new LineCoordinates(coordList.toArray(new Coordinates[coordList.size()]));
    }

    public Line(double[]... coords) {
        if (coords.length < 2) {
            throw new IllegalArgumentException("A line takes at least 2 coordinate pairs!");
        }
        List<Coordinates> coordsL = new ArrayList<>();
        for (double[] c : coords) {
            if (c.length != 2) {
                throw new IllegalArgumentException("Each coordinate pair should have two doubles!");
            }
            coordsL.add(new Coordinates(c[0], c[1]));
        }
        this.coordinates = new LineCoordinates(coordsL.toArray(new Coordinates[coordsL.size()]));
    }

    public LineCoordinates getCoordinates() {
        return this.coordinates;
    }

    @Override
    public GeoType getGeoType() {
        return GeoType.LINE;
    }

}