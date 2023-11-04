import java.util.*;

public class HousingEstate {
    private static int nextId = 1;
    private static List<HousingEstate> estates = new ArrayList<>();
    private  List<Room> rooms;
    private int id;
    private String name;
    private List<Apartment> apartments;

    public HousingEstate(String name) {
        this.name = name;
        this.id = nextId++;
        this.rooms = new ArrayList<>();
        estates.add(this);
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void addRoom(Room room) {
        this.rooms.add(room);
    }

    public List<Apartment> getApartments() {
        return apartments;
    }

    public int getId() {
        return id;
    }

    public static List<HousingEstate> getEstates() {
        return estates;
    }

    public String getName() {
        return name;
    }

    public static HousingEstate getById(int id) {
        return estates.stream()
                .filter(estate -> estate.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public String toString() {
        return "Housing Estate ID: " + id + ", name: " + name;
    }
}
