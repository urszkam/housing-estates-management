package estate.Rooms;

import estate.HousingEstate;
import tenants.Person;
import rents.Rent;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Room {
    private static int nextId = 1;
    private boolean isRented;
    private int id;
    private double volume;
    private HousingEstate housingEstate;
    private RoomType roomType;
    private Person responsibleForFees;
    private static List<Room> rooms = new ArrayList<>();

    public Room(HousingEstate estate, RoomType roomType, double volume) {
        this.isRented = false;
        this.id = nextId++;
        this.volume = volume;
        this.housingEstate = estate;
        this.roomType = roomType;
        this.responsibleForFees = null;
        rooms.add(this);
        estate.addRoom(this);
    }

    public Room(HousingEstate estate, RoomType roomType, double length, double width, double height) {
        this.isRented = false;
        this.id = nextId++;
        this.volume = this.calculateVolume(length, width, height);
        this.housingEstate = estate;
        this.roomType = roomType;
        this.responsibleForFees = null;
        rooms.add(this);
        estate.addRoom(this);
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public Person getResponsibleForFees() {
        return responsibleForFees;
    }

    private double calculateVolume(double a, double b, double c) {
        return a*b*c;
    }


    public boolean isRented() {
        return isRented;
    }

    public void setRent(boolean rent) {
        if (isRented != rent)
            isRented = rent;
    }

    public double getVolume() {
        return volume;
    }

    public int getId() {
        return id;
    }

    public void setResponsibleForFees (Person person) {
        if (this.responsibleForFees == null)
            this.responsibleForFees = person;
    }

    public HousingEstate getHousingEstate() {
        return housingEstate;
    }

    public boolean startNewRent(Person tenant) {
        if (tenant.canRent() && !this.isRented) {
            this.setResponsibleForFees(tenant);
            this.setRent(true);
            tenant.addRoom(this);
            return true;
        }
        return false;
    }

    public Rent findRent() {
        List<Rent> rents = Rent.getRents();
        return rents.stream()
                .filter(rent -> rent.getRoom() == this)
                .findFirst()
                .orElse(null);};

    public static List<Room> getRooms() {
        return rooms;
    }

    public static Room getById(int id) {
        return rooms.stream()
                .filter(room -> room.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public static List<Room> getByType(RoomType roomType) {
        return rooms.stream()
                .filter(room -> room.getRoomType() == roomType)
                .collect(Collectors.toList());
    }

    public static Room getByIdAndType(int id, RoomType type) {
        return rooms.stream()
                .filter(room -> room.getId() == id && room.getRoomType() == type)
                .findFirst()
                .orElse(null);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder()
                .append("ID: ").append(id).append(",")
                .append(" volume: ").append(volume).append(" m^3");
        return str.toString();
    }
}
