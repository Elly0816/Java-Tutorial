package com.abc.first;

public class Item {

    private String type;

    public Item(String type) {
        this.type = type;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "{" +
                " type='" + this.getType() + "'" +
                "}";
    }

}