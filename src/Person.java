import java.util.*;

public class Person {
    private static final int maxRooms = 5;
    private static List<Person> people = new ArrayList<>();
    private static int nextId = 1;
    private String name;
    private String surname;
    private String address;
    private int id;
    private boolean responsibleForFees;
    private List<Room> rooms;
    private List<TenantLetter> letters;

    public Person (String name, String surname, String address) {
        this.id = nextId++;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.responsibleForFees = false;
        this.rooms = new ArrayList<>();
        this.letters = new ArrayList<>();
        people.add(this);
    }

    public static List<Person> getPeople() {
        return people;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getFullName() {
        return name + " " + surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public static int getMaxRooms() {
        return maxRooms;
    }

    public void addRoom(Room room) {
            rooms.add(room);
    }

    public void removeRoom(Room room) {
        rooms.remove(room);
    }

    public void addLetter(TenantLetter letter) {
        letters.add(letter);
    }

    public void checkNumOfLetters() throws ProblematicTenantException {
        if (letters.size() > 3)
            throw new ProblematicTenantException(this);
    }

    public boolean canRent() {
        return rooms.size() < maxRooms;
    }

    public static Person getById(int id) {
        return people.stream()
                .filter(person -> person.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder()
                .append(this.getFullName())
                .append(", address: ").append(address);
        return str.toString();
    }
}
