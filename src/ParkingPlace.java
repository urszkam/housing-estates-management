import java.util.*;

public class ParkingPlace extends Room {
    private static List<ParkingPlace> places = new ArrayList<>();
    private List<Item> itemsIn;

    public ParkingPlace(HousingEstate estate, double volume) {
        super(estate, RoomType.PARKINGPLACE, volume);
        this.itemsIn = new ArrayList<>();
        places.add(this);
    }

    public ParkingPlace(HousingEstate estate, double length, double width, double height) {
        super(estate, RoomType.PARKINGPLACE, length, width, height);
        this.itemsIn = new ArrayList<>();
        places.add(this);
    }
    public static List<ParkingPlace> getPlaces() {
        return places;
    }

    public List<Item> getItemsIn() {
        return itemsIn;
    }

    private double calculateFreeSpace() {
        double spaceTaken = itemsIn.stream()
                .mapToDouble(Item::getVolume)
                .sum();
        return this.getVolume() - spaceTaken;
    }

    public void takeIn(Item item) throws TooManyThingsException {
        if (item.getVolume() > this.calculateFreeSpace())
            throw new TooManyThingsException();
        itemsIn.add(item);
    }

    public void takeOut(Item item) {
        itemsIn.remove(item);
    }

    @Override
    public Rent findRent() {
        List<Rent> rents = Rent.getRents();
        return rents.stream()
                .filter(rent -> rent.getParking() == this)
                .findFirst()
                .orElse(null);
    }

    @Override
    public String toString() {
        return "Parking Place " + super.toString();
    }
}