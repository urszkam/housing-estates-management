public abstract class Vehicle extends Item {
    private double engineCapacity;
    private EngineType engineType;

    public Vehicle(String name, double engineCapacity, EngineType engineType, double volume) {
        super(name, volume);
        this.engineCapacity = engineCapacity;
        this.engineType = engineType;
    }

    public Vehicle(String name, double engineCapacity, EngineType engineType, double length, double width, double height) {
        super(name, length, width, height);
        this.engineCapacity = engineCapacity;
        this.engineType = engineType;
    }

    public double getEngineCapacity() {
        return engineCapacity;
    }

    public EngineType getEngineType() {
        return engineType;
    }
}
