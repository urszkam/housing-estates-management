package estate;

import estate.Rooms.Room;
import estate.Rooms.RoomType;

import java.util.*;
import java.util.stream.Collectors;

public class HousingEstate {
    private static int nextId = 1;
    private static List<HousingEstate> estates = new ArrayList<>();
    private int id;
    private String name;
    private List<Room> rooms;

    public HousingEstate(String name) {
        this.name = name;
        this.id = nextId++;
        this.rooms = new ArrayList<>();
        estates.add(this);
    }

    public List<? extends Room> getRooms() {
        return rooms;
    }

    public List<Room> getRooms(RoomType roomType) {
        return rooms.stream()
                .filter(room -> room.getRoomType() == roomType)
                .sorted(Comparator.comparing(Room::getId))
                .collect(Collectors.toList());
    }

    public <T extends Room> void addRoom(T room) {
        rooms.add(room);
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
