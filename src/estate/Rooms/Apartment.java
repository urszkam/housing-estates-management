package estate.Rooms;

import estate.HousingEstate;
import tenants.Person;

import java.util.*;

public class Apartment extends Room {
    private static List<Apartment> apartments = new ArrayList<>();
    private List<Person> checkedIn;


    public Apartment(HousingEstate estate, double volume) {
        super(estate, RoomType.APARTMENT, volume);
        this.checkedIn = new ArrayList<>();
        apartments.add(this);
    }

    public Apartment(HousingEstate estate, double length, double width, double height) {
        super(estate, RoomType.APARTMENT, length, width, height);
        this.checkedIn = new ArrayList<>();
        apartments.add(this);
    }

    public static List<Apartment> getApartments() {
        return apartments;
    }

    public void checkIn(Person tenant) {
        checkedIn.add(tenant);
    }

    public void checkOut(Person tenant) {
        checkedIn.remove(tenant);
    }
    public void checkOutAll() {
        for (Person person : checkedIn) {
            person.removeRoom((Room) this);
        }
        checkedIn.clear();
    }

    public List<Person> getCheckedIn() {
        return checkedIn;
    }

    @Override
    public String toString() {
        return "Estate.Rooms.Apartment " + super.toString();
    }
}
