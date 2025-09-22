package dev.ele;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Coordinates riverStart = new Coordinates(22.526, 36.723);
        Coordinates riverMiddle = new Coordinates(56.2523, 59.364);
        Coordinates riverEnd = new Coordinates(35.2462, 34.753);
        Coordinates riverEnd2 = new Coordinates(-24.1631, 34.753);
        River nile = new River("Nile", new LineCoordinates(riverStart,
                riverMiddle, riverEnd, riverEnd2));
        River congo = new River("Congo", "22.526, 36.723", "56.2523, 59.364", "35.2462, 34.753", "22.526, 36.723");
        River niger = new River("Niger", new double[] { 22.526, 36.723 }, new double[] { 56.2523, 59.364 },
                new double[] { 35.2462, 34.753 }, new double[] { 22.526, 36.723 });
        // River benueRiver = new River("Benue", new LineCoordinates(riverStart,
        // riverMiddle, riverEnd));

        Park serengeti = new Park("Serengeti", "National Park", new Coordinates(-26.26424, -13.243));
        Park kruger = new Park("Kruger", "National Park", "-23.425, 14.522");
        Park masaiMara = new Park("Masai Mara", -23.425, 14.522);

        Layer<River> greatAfricanRivers = new Layer<>();
        Layer<Park> greatAfricanParks = new Layer<>();

        greatAfricanRivers.addElements(List.of(congo, niger, nile));
        greatAfricanParks.addElements(List.of(masaiMara, kruger, serengeti));

        greatAfricanParks.renderLayer();
        greatAfricanRivers.renderLayer();
    }

}