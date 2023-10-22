public class CityCar extends Vehicle{
    private boolean parkingAssist;

    public CityCar(String name, double engineCapacity, EngineType engineType, boolean parkingAssist, double volume) {
        super(name, engineCapacity, engineType, volume);
        this.parkingAssist = parkingAssist;
    }

    public CityCar(String name, double engineCapacity, EngineType engineType, boolean parkingAssist, double length, double width, double height) {
        super(name, engineCapacity, engineType, length, width, height);
        this.parkingAssist = parkingAssist;
    }

    public boolean isParkingAssist() {
        return parkingAssist;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + (parkingAssist ? "" : "no ") + "parking assist";
    }
}
