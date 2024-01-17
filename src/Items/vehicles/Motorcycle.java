package Items.vehicles;

import Items.vehicles.types.EngineType;

public class Motorcycle extends Vehicle {
    private double seatHeight;
    public Motorcycle(String name, double engineCapacity, EngineType engineType, double seatHeight, double volume) {
        super(name, engineCapacity, engineType, volume);
        this.seatHeight = seatHeight;
    }

    public Motorcycle(String name, double engineCapacity, EngineType engineType, double seatHeight, double length, double width, double height) {
        super(name, engineCapacity, engineType, length, width, height);
        this.seatHeight = seatHeight;
    }

    @Override
    public String toString() {
        return super.toString() + ", seat height: " + seatHeight;
    }
}
