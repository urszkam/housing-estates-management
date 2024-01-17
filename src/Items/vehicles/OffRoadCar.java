package Items.vehicles;

import Items.vehicles.types.EngineType;

public class OffRoadCar extends Vehicle {
    private double groundClearance;
    public OffRoadCar(String name, double engineCapacity, EngineType engineType, double groundClearance, double volume) {
        super(name, engineCapacity, engineType, volume);
        this.groundClearance = groundClearance;
    }

    public OffRoadCar(String name, double engineCapacity, EngineType engineType, double groundClearance, double length, double width, double height) {
        super(name, engineCapacity, engineType, length, width, height);
        this.groundClearance = groundClearance;
    }
    public double getGroundClearance() {
        return groundClearance;
    }

    @Override
    public String toString() {
        return super.toString() + ", ground clearance: " + groundClearance;
    }
}
