package rents;

import estate.Rooms.Apartment;
import estate.HousingEstate;
import estate.Rooms.ParkingPlace;
import estate.Rooms.Room;
import estate.Rooms.RoomType;
import Items.vehicles.Item;
import tenants.Person;
import util.Calendar;
import util.FileIO;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Status {
    private HousingEstate estate;
    private String content;
    private int id;
    private static int idCounter = 1;

    public Status(HousingEstate estate) {
        this.estate = estate;
        this.id = idCounter++;
        this.content = createContent();
        saveStatus();
    }

    public String getContent() {
        return content;
    }

    public String createContent() {
        StringBuilder status = new StringBuilder()
                .append("-----------------------------------------------\n")
                .append("rents.Status ID: " + id + ", date: " + Calendar.getToday() + "\n")
                .append("Housing Estate: " + estate.getName() + "\n\n");

        Comparator<Room> roomComparator = Comparator.comparing(Room::getVolume);
        Comparator<Item> itemComparator = Comparator
                .comparing(Item::getVolume, (v1, v2) -> Double.compare(v2, v1))
                .thenComparing(Item::getName);

        List<? extends Room> rooms = estate.getRooms();
        Collections.sort(rooms, roomComparator);

        int id = 1;
        for (Room room : rooms) {
            status.append(id++).append(". ").append(room).append(", ");
            if (room.isRented()) {
                Rent rent = room.findRent();
                status.append("\n\trented by: ").append(rent.getTenant().getFullName())
                        .append(" (").append(rent.getTenant().getAddress()).append(")")
                        .append(" from ").append(rent.getStartDate()).append(" to ").append(rent.getEndDate())
                        .append("\n");
            } else status.append("not rented.\n");

            if (room.getRoomType() == RoomType.PARKINGPLACE) {
                ParkingPlace pp = (ParkingPlace) room;
                if (pp.getItemsIn().isEmpty()) continue;
                status.append("\tItems stored/parked in the parking place:\n");
                List<Item> items = pp.getItemsIn();
                Collections.sort(items, itemComparator);
                for (Item item : items) {
                    status.append("\t* ").append(item).append("\n");
                }
            } else {
                Apartment apt = (Apartment) room;
                if (apt.getCheckedIn().isEmpty()) continue;
                status.append("\tPeople checked in the apartment:\n");
                for (Person person : apt.getCheckedIn())
                    status.append("\t\t").append(person.getFullName()).append(" (" + person.getAddress() + ")").append("\n");
            }
        }
        status.append("-----------------------------------------------");
        return String.valueOf(status);
    }

    public void saveStatus() {
        new FileIO(this);
    }
}