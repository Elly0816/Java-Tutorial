package dev.ele;

public interface Mappable {

    String JSON_PROPERTY = """
            "properties": {%s}
            """;

    String getLabel();

    GeoType getGeoType();

    IconType getIconType();

    default String toJSON() {
        String toReturn = """
                "type": %s, "label": %s, "marker": %s" """.formatted(getGeoType(), getLabel(),
                getIconType().name().replace("_", " "));
        return toReturn;
    }

    static void mapIt(Mappable item) {
        System.out.println(Mappable.JSON_PROPERTY.formatted(item.toJSON()));
    }

}