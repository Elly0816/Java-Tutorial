package dev.ele;

public class Building implements Mappable {

    private GeoType geoType = GeoType.POINT;
    private String name;
    private Usage usage;
    private IconType marker;

    public Building(String name, Usage usage, IconType marker) {
        this.name = name;
        this.usage = usage;
        this.marker = marker;
    }

    @Override
    public String getLabel() {
        return getName() + " (" + getUsage().name() + ")";
    }

    private String getName() {
        return this.name;
    }

    private Usage getUsage() {
        return this.usage;
    }

    @Override
    public GeoType getGeoType() {
        return this.geoType;
    }

    @Override
    public IconType getIconType() {
        return this.marker;
    }

    @Override
    public String toJSON() {
        return Mappable.super.toJSON() + """
                , "name": "%s", "usage": "%s" """.formatted(getName(), getUsage());
    }
}