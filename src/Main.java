import java.util.*;
public class Main {

    private static void createPeople(int num) {
        List<String> surnames = Arrays.asList(
                "Smith", "Johnson", "Williams", "Brown", "Davis",
                "Jones", "Miller", "Wilson", "Moore", "Taylor"
        );

        List<String> names = Arrays.asList(
                "John", "Mary", "David", "Sarah", "James",
                "Emily", "Michael", "Jennifer", "Robert", "Jessica"
        );

        List<String> cities = Arrays.asList(
                "Warsaw", "Krakow", "Gdansk", "Wroclaw", "Poznan",
                "Lodz", "Szczecin", "Lublin", "Katowice", "Bialystok"
        );

        List<String> streets = Arrays.asList(
                "Pilsudskiego", "Dluga", "Krolewska", "Mickiewicza", "Wiejska",
                "Kosciuszki", "Sienkiewicza", "Jana Pawla II", "Kopernika", "Sobieskiego"
        );

        Random random = new Random();
        for (int i = 0; i < num; i++) {
            String name = names.get(random.nextInt(names.size()));
            String surname = surnames.get(random.nextInt(surnames.size()));
            String street = streets.get(random.nextInt(streets.size()));
            String city = cities.get(random.nextInt(cities.size()));
            int building = random.nextInt(100) + 1;
            String address = building + " " + street + " Street, " + city;

            new Person(name, surname, address);
        }

    }

    private static void createApartments(int num, HousingEstate estate) {
        Random random = new Random();
        for (int i = 0; i < num; i++) {
            Double volume = 70 + (110 * random.nextDouble());
            volume = Math.round(volume * 100.0) / 100.0;
            new Apartment(estate, volume);
        }
    }

    private static void createParkingPlaces(int num, HousingEstate estate) {
        Random random = new Random();
        for (int i = 0; i < num; i++) {
            Double volume = 23 + (17 * random.nextDouble());
            volume = Math.round(volume * 100.0) / 100.0;
            new ParkingPlace(estate, volume);
        }
    }

    private static void createVehicles() {
        new Amphibious("no. 1", 2.5, EngineType.OTHER, 70, 25, 20.0);
        new Boat("Nadine", 150.0, EngineType.DIESEL, BoatType.SAILBOAT, 15.0);
        new CityCar("Tesla", 1.6, EngineType.ELECTRIC, false, 3.5);
        new Motorcycle("Harley", 1.0, EngineType.PETROL, 1.1, 5.0);
        new OffRoadCar("MyOffRoadCar", 2.5, EngineType.DIESEL, 0.5, 25.0);
    }

    private static void createItems(int num) {
        List<String> items = Arrays.asList(
                "Luggage", "Golf Bag", "Skateboard", "Box", "Shopping Cart",
                "Toolbox", "Surfboard", "Snowboard", "Wheelchair", "Skis"
        );

        Random random = new Random();
        for (int i = 0; i < num; i++) {
            String item = items.get(random.nextInt(items.size()));
            Double volume = 1 + (4 * random.nextDouble());
            volume = Math.round(volume * 100.0) / 100.0;
            new Item(item, volume);
        }
    }

    private static void storeItems(){
        int size = ParkingPlace.getPlaces().size();
        for (int i = 0; i < size; i++) {
            ParkingPlace pp = ParkingPlace.getPlaces().get(i);
            try {
                pp.takeIn(Item.getItems().get(i));
            } catch (Exception e) {
                System.out.println(e);
            }
            try {
                pp.takeIn(Item.getItems().get(9-i));
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    private static void rentApartments() {
//        int size = Apartment.getApartments().size() - 3;
//        for (int i = 0; i < size; i++) {
//            new Rent()
//        }
    }

    public static void main(String[] args) {
        new Calendar();

        HousingEstate es1 = new HousingEstate("Okopowa Apartments");
        createPeople(20);
        createApartments(10, es1);
        createParkingPlaces(5, es1);
        createVehicles();
        createItems(5);
        storeItems();
        rentApartments();



        Apartment ap1 = new Apartment(es1,90);
        Apartment ap2 = new Apartment(es1, 12, 10, 2.7);
        Apartment ap3 = new Apartment(es1, 12, 10, 2.7);
        Apartment ap4 = new Apartment(es1, 12, 10, 2.7);
        ParkingPlace pp1 = new ParkingPlace(es1, 11);
        ParkingPlace pp2 = new ParkingPlace(es1, 12, 10, 2.7);
        Person p1 = Person.getPeople().get(0);
        Person p2 = Person.getPeople().get(1);
        Person p3 = Person.getPeople().get(5);
        Item item = new Item("box", 12);
        Amphibious am1 = new Amphibious("Catalena", 1.3, EngineType.OTHER, 70, 120, 2, 5.5, 2);
        try {
            pp1.takeIn(item);
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            pp2.takeIn(am1);
        } catch (Exception e) {
            System.out.println(e);
        }
        Rent rent1 = new Rent(p1, Calendar.getToday(), "2023-10-26", ap1, pp1);
        Rent rent2 = new Rent(p2, Calendar.getToday(), "2023-10-31", ap3, pp2);
        Rent rent3 = new Rent(p1, "2023-09-01", "2023-11-12", ap2);
        Rent rent4 = new Rent(p3, "2023-09-01", "2023-11-12", ap4);

        new Menu();
        new FileIO(es1);


    }

}