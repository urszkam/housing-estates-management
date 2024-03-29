package Items.vehicles;

import Items.vehicles.types.BoatType;
import Items.vehicles.types.EngineType;

public class Boat extends Vehicle {
    private final BoatType boatType;
    public Boat(String name, double engineCapacity, EngineType engineType, BoatType boatType, double volume) {
        super(name, engineCapacity, engineType, volume);
        this.boatType = boatType;
    }

    public Boat(String name, double engineCapacity, EngineType engineType, BoatType boatType, double length, double width, double height) {
        super(name, engineCapacity, engineType, length, width, height);
        this.boatType = boatType;
    }

    public BoatType getBoatType() {
        return boatType;
    }

    @Override
    public String toString() {
        return super.toString() + ", boat type: " + boatType;
    }
}
