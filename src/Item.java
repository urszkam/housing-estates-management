import java.util.*;

public class Item {
    private static List<Item> items = new ArrayList<>();
    private double volume;
    private String name;
    private static int nextId = 1;
    private int id;

    public Item(String name, double volume) {
        this.id = nextId++;
        this.volume = volume;
        this.name = name;
        items.add(this);
    }

    public Item(String name, double length, double width, double height) {
        this.id = nextId++;
        this.volume = this.calculateVolume(length, width, height);
        this.name = name;
        items.add(this);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static List<Item> getItems() {
        return items;
    }

    public double getVolume() {
        return volume;
    }

    private double calculateVolume(double a, double b, double c) {
        return a*b*c;
    }

    public static Item getById(int id) {
        return items.stream()
                .filter(item -> item.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public String toString() {
        return  name + ", volume: " + volume + " m^3" ;
    }
}
