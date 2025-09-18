package dev.ele;

public class UtilityLine implements Mappable {

    private GeoType geoType = GeoType.LINE;

    private String name;
    private Usage utility;
    private IconType marker;

    public UtilityLine(String name, Usage utility, IconType marker) {
        this.name = name;
        this.utility = utility;
        this.marker = marker;
    }

    @Override
    public String getLabel() {
        return getName() + " (" + getUtility().name() + ")";
    }

    private String getName() {
        return this.name;
    }

    private Usage getUtility() {
        return this.utility;
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
                , "name": "%s", "utility": "%s" """.formatted(getName(), getUtility());
    }

}