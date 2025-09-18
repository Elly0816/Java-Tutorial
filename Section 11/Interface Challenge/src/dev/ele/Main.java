package dev.ele;

import java.util.ArrayList;
import java.util.List;

public class Main {

    static List<Mappable> items = new ArrayList<>();

    public static void main(String[] args) {
        Mappable whiteHouse = new Building("White House", Usage.GOVERNMENT, IconType.BLACK_PUSH_PIN);
        Mappable fibreOptic = new UtilityLine("Ocean Bedrock", Usage.FIBRE_OPTIC, IconType.RED_SOLID_LINE);
        Mappable railLine = new UtilityLine("UpTown Rail", Usage.RAIL, IconType.RED_SOLID_LINE);
        Mappable fireStation = new Building("Metro Fire Station", Usage.FIRE_STATION, IconType.BLACK_PUSH_PIN);
        items.addAll(List.of(whiteHouse, fibreOptic, railLine, fireStation));

        mapIt();
    }

    private static void mapIt() {
        for (Mappable m : items) {
            Mappable.mapIt(m);
            separator();
        }
    }

    private static void separator() {
        System.out.println("_".repeat(50));
    }

}