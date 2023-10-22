public class Motorcycle extends Vehicle{
    private double seatHeight;
    public Motorcycle(String name, double engineCapacity, EngineType engineType, double seatHeight, int maxLandSpeed, int maxWaterSpeed, double volume) {
        super(name, engineCapacity, engineType, volume);
        this.seatHeight = seatHeight;
    }

    public Motorcycle(String name, double engineCapacity, EngineType engineType, double seatHeight, int maxLandSpeed, int maxWaterSpeed, double length, double width, double height) {
        super(name, engineCapacity, engineType, length, width, height);
        this.seatHeight = seatHeight;
    }
}
