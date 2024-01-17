package Items.vehicles;

import Items.vehicles.types.EngineType;

public class Amphibious extends Vehicle {
    private int maxLandSpeed;

    public Amphibious(String name, double engineCapacity, EngineType engineType, int maxLandSpeed, double volume) {
        super(name, engineCapacity, engineType, volume);
        this.maxLandSpeed = maxLandSpeed;
    }

    public Amphibious(String name, double engineCapacity, EngineType engineType, int maxLandSpeed, double length, double width, double height) {
        super(name, engineCapacity, engineType, length, width, height);
        this.maxLandSpeed = maxLandSpeed;
    }

    public int getMaxLandSpeed() {
        return maxLandSpeed;
    }

    @Override
    public String toString() {
        return super.toString() + ", max land speed: " + maxLandSpeed;
    }
}