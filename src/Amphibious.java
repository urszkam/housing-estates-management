public class Amphibious extends Vehicle{
    private int maxLandSpeed;
    private int maxWaterSpeed;

    public Amphibious(String name, double engineCapacity, EngineType engineType, int maxLandSpeed, int maxWaterSpeed, double volume) {
        super(name, engineCapacity, engineType, volume);
        this.maxLandSpeed = maxLandSpeed;
        this.maxWaterSpeed = maxWaterSpeed;
    }

    public Amphibious(String name, double engineCapacity, EngineType engineType, int maxLandSpeed, int maxWaterSpeed, double length, double width, double height) {
        super(name, engineCapacity, engineType, length, width, height);
        this.maxLandSpeed = maxLandSpeed;
        this.maxWaterSpeed = maxWaterSpeed;
    }

    public int getMaxLandSpeed() {
        return maxLandSpeed;
    }

    public int getMaxWaterSpeed() {
        return maxWaterSpeed;
    }

    @Override
    public String toString() {
        return super.toString() + ", max land speed: " + maxLandSpeed;
    }
}