package dev.ele.exa;

public class PlainOld {

    private static int last_id = 1;

    private int id;

    public PlainOld() {
        id = PlainOld.last_id++;
        System.out.println("Creating the PlainOld Object: id = " + id);
    }

    @Override
    public String toString() {
        return "id: " + id;
    }
}