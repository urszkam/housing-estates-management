import java.util.*;

public abstract class Vehicle extends Item {
    private static List<Vehicle> vehicles = new ArrayList<>();
    private double engineCapacity;
    private EngineType engineType;

    public Vehicle(String name, double engineCapacity, EngineType engineType, double volume) {
        super(name, volume);
        this.engineCapacity = engineCapacity;
        this.engineType = engineType;
        vehicles.add(this);
    }

    public Vehicle(String name, double engineCapacity, EngineType engineType, double length, double width, double height) {
        super(name, length, width, height);
        this.engineCapacity = engineCapacity;
        this.engineType = engineType;
        vehicles.add(this);
    }

    public double getEngineCapacity() {
        return engineCapacity;
    }

    public EngineType getEngineType() {
        return engineType;
    }

    @Override
    public String toString() {
        return super.toString() + ", engine type: " + engineType;
    }
}
