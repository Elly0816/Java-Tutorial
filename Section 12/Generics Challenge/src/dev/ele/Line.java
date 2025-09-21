package dev.ele;

import java.util.List;

public abstract class Line implements Mappable {

    private final LineCoordinates coordinates;

    public Line(LineCoordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Line(String... coordinates) {
        List<String> coords = List.of(coordinates);
        if (coords.size() != 3) {
            throw new IllegalArgumentException("Only 3 coordinate pairs allowed!");
        }
        double[][] latsAndLongs = new double[3][2];
        int i = 0;
        for (String c : coords) {
            latsAndLongs[i] = Mappable.stringToLatLon(c);
            i++;
        }
        Coordinates[] coordList = new Coordinates[3];
        for (int l = 0; l < 3; l++) {
            coordList[l] = new Coordinates(latsAndLongs[l][0], latsAndLongs[l][1]);
        }
        this.coordinates = new LineCoordinates(coordList[0], coordList[1], coordList[2]);
    }

    public Line(double[]... coords) {
        if (coords.length != 3) {
            throw new IllegalArgumentException("A line takes 3 coordinate pairs!");
        }
        Coordinates[] coordsL = new Coordinates[3];
        int i = 0;
        for (double[] c : coords) {
            if (c.length != 2) {
                throw new IllegalArgumentException("Each coordinate pair should have two doubles!");
            }
            coordsL[i++] = new Coordinates(c[0], c[1]);
        }
        this.coordinates = new LineCoordinates(coordsL[0], coordsL[1], coordsL[2]);
    }

    public LineCoordinates getCoordinates() {
        return this.coordinates;
    }

    @Override
    public GeoType getGeoType() {
        return GeoType.LINE;
    }

}