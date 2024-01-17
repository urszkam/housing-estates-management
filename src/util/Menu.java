package util;

import estate.Rooms.Apartment;
import estate.HousingEstate;
import estate.Rooms.ParkingPlace;
import estate.Rooms.Room;
import estate.Rooms.RoomType;
import Items.vehicles.*;
import Items.vehicles.types.BoatType;
import Items.vehicles.types.EngineType;
import Items.vehicles.types.VehicleType;
import tenants.Person;
import rents.Rent;
import rents.Status;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Menu implements Runnable{
    private Scanner scanner;
    public Menu() {
        scanner = new Scanner(System.in);
        new Thread(this).start();
    }

    private int validateInput(int max) {
        String options = max <= 1 ? "" : "between 1 and " + max + " ";
        int input = -1;
        boolean isValid = false;
        while (!isValid) {
            System.out.print("\tChoose option " + options + "or type 0 to get back to menu: ");
            try {
                input = scanner.nextInt();
                if (input >= 0 && (max == 0 || input <= max)) isValid = true;
                else System.out.println("\n\tInput is out of range.\n");
            } catch (Exception e) {
                System.out.println("\n\tInvalid input. Please enter an integer.\n");
                scanner.nextLine();
            }
        }
        return input;
    }

    private String validateInputPattern(String objName, String field, String pattern) {
        System.out.println("\nType down new " + objName + "'s " + field + ": ");
        String input = "";
        while (input.isEmpty() || !input.matches(pattern) || input.equals("0")) {
            try {
                input = scanner.nextLine().trim();
                if (input.isEmpty() || !input.matches(pattern) || input.equals("0"))
                    System.out.println("\n\tIncorrect input format. Try again.\n");
            } catch (Exception e) {
            System.out.println("\n\tIncorrect input.");
            }
        }
        System.out.println("\n");
        return input;
    }

    private RoomType chooseRoomType() {
        System.out.println("\tChoose type of the room:\n" +
                "\t1. Apartment\n" +
                "\t2. Parking Place\n");

        int input = validateInput(2);

        RoomType roomType = switch (input) {
            case 1 -> RoomType.APARTMENT;
            case 2 -> RoomType.PARKINGPLACE;
            default -> null;
        };

        return roomType ;
    }

    private String chooseItemType() {
        System.out.println("\tChoose type of the item:\n" +
                "\t1. Car\n" +
                "\t2. Other\n");

        int input = validateInput(2);

        String type = switch (input) {
            case 1 -> "Vehicle";
            case 2 -> "Other";
            default -> null;
        };

        return type;
    }

    private VehicleType chooseCarType() {
        System.out.println("\tChoose type of the Car:\n" +
                "\t1. Amphibious\n" +
                "\t2. Boat\n" +
                "\t3. City Car\n" +
                "\t4. Motorcycle\n" +
                "\t5. Off-Road Car\n");

        int input = validateInput(5);

        VehicleType type = switch (input) {
            case 1 -> VehicleType.AMPHIBIOUS;
            case 2 -> VehicleType.BOAT;
            case 3 -> VehicleType.CITY_CAR;
            case 4 -> VehicleType.MOTORCYCLE;
            case 5 -> VehicleType.OFF_ROAD_CAR;
            default -> null;
        };

        return type;
    }

    private EngineType chooseEngineType() {
        System.out.println("\tChoose type of the Engine:\n" +
                "\t1. Gasoline\n" +
                "\t2. Diesel\n" +
                "\t3. Electric\n" +
                "\t4. Petrol\n" +
                "\t5. Other\n");

        int input = validateInput(5);

        EngineType type = switch (input) {
            case 1 -> EngineType.GASOLINE;
            case 2 -> EngineType.DIESEL;
            case 3 -> EngineType.ELECTRIC;
            case 4 -> EngineType.PETROL;
            case 5 -> EngineType.OTHER;
            default -> null;
        };

        return type;
    }

    private BoatType chooseBoatType() {
        System.out.println("\tChoose type of the Boat:\n" +
                "\t1. Yacht\n" +
                "\t2. Motorboat\n" +
                "\t3. Sailboat\n" +
                "\t4. PWC\n" +
                "\t5. Other\n");

        int input = validateInput(5);

        BoatType type = switch (input) {
            case 1 -> BoatType.YACHT;
            case 2 -> BoatType.MOTORBOAT;
            case 3 -> BoatType.SAILBOAT;
            case 4 -> BoatType.PWC;
            case 5 -> BoatType.OTHER;
            default -> null;
        };

        return type;
    }

    public void showMain() {
        System.out.println("\n--------------------------------\n" +
                "\t MENU\n" +
                "\tchoose desired option by writing down its number \n" +
                "--------------------------------\n" +
                "\t1. Housing Estates\n" +
                "\t2. Estate.Rooms\n" +
                "\t3. Tenants\n" +
                "\t4. Items\n" +
                "\t5. Rents\n" +
                "\t6. Generate a Report\n");
        int input = 0;
        boolean isValid = false;
        while (!isValid) {
            System.out.print("Choose option between " + 1 + " and " + 6 + ": ");
            try {
                input = scanner.nextInt();
                if (input >= 1 && input <= 6) {
                    isValid = true;
                } else {
                    System.out.println("Input is out of range.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.nextLine();
            }
        }

        switch (input) {
            case 1 -> housingEstateMenu();
            case 2 -> roomsMenu();
            case 3 -> tenantsMenu();
            case 4 -> itemsMenu();
            case 5 -> rentsMenu();
            case 6 -> generateReportMenu();
        }
    }
    public void housingEstateMenu() {
        System.out.println("\n--------------------------------\n" +
                "\tHOUSING ESTATES\n" +
                "\tchoose desired option by writing down its number \n" +
                "--------------------------------\n" +
                "\t1. Show Housing Estates\n" +
                "\t2. Create new Housing Estate\n" +
                "\t0. Get back to Main Menu\n" +
                "--------------------------------\n\n");
        int input = -1;
        boolean isValid = false;
        while (!isValid) {
            System.out.print("Choose option between " + 0 + " and " + 2 + ": ");
            try {
                input = scanner.nextInt();
                if (input >= 0 && input <= 2) {
                    isValid = true;
                } else {
                    System.out.println("Input is out of range.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.nextLine();
            }
        }

        switch (input) {
            case 1 -> showHousingEstates();
            case 2 -> createHousingEstate();
            case 0 -> showMain();
        }
    }

    private void showHousingEstates() {
        System.out.println("\n--------------------------------\n" +
                "\tLIST OF HOUSING ESTATES \n");
        for (HousingEstate estate : HousingEstate.getEstates())
            System.out.println(estate);
        System.out.println("\n--------------------------------\n");
        housingEstateMenu();
    }

    private void createHousingEstate() {
        System.out.println("\n--------------------------------\n" +
                "\tCreate Housing Estate \n" +
                "\tWrite down the new Housing Estate data\n" +
                "\tor choose 0 to get back to Main Menu\n" +
                "--------------------------------\n");

        String housingEstateName = "";
        System.out.print("Provide a name for the Housing Estate:");
        while (housingEstateName.isEmpty() || !housingEstateName.matches("[a-zA-Z' 0-9]+")) {
            try {
                housingEstateName = scanner.nextLine().trim();
            } catch (Exception e) {
                System.out.println("Incorrect input.");
            }
        }

        if (housingEstateName.equals("0")) {
            housingEstateMenu();
        }

        try {
            HousingEstate estate = new HousingEstate(housingEstateName);
            System.out.println(estate);
        } catch (Exception e) {
            System.out.println(e + " Housing Estate cannot be created.");
        }
        housingEstateMenu();
    }

    public void roomsMenu() {
        System.out.println("\n--------------------------------\n" +
                "\tROOMS\n" +
                "\tchoose desired option by writing down its number \n" +
                "--------------------------------\n" +
                "\t1. Show rooms\n" +
                "\t2. Find room by ID\n" +
                "\t3. Create a new room\n" +
                "\t0. Get back to Main Menu\n");

        int input = validateInput(3);

        switch (input) {
            case 1 -> showAllRooms();
            case 2 -> findRoomById();
            case 3 -> createRoom();
            case 0 -> showMain();
        }

    }

    private void showAllRooms() {

        RoomType roomType = chooseRoomType();
        if (roomType == null) roomsMenu();

        System.out.println("\n--------------------------------\n" +
                "\tLIST OF CHOSEN ROOMS \n");
        for (HousingEstate estate : HousingEstate.getEstates()) {
            for (Room room : estate.getRooms(roomType))
                System.out.println(estate + ", " + room);
        }
        System.out.println("\n--------------------------------\n");
        roomsMenu();
    }

    private void findRoomById() {
        System.out.println("\n--------------------------------\n");
        RoomType roomType = chooseRoomType();
        if (roomType == null) roomsMenu();

        int max = Room.getRooms().size();
        System.out.println("\n--------------------------------\n" +
                "\tFIND "+ roomType +" BY ID\n" +
                "\tWrite down the ID number of a chosen room \n" +
                "\tor choose 0 to get back to Main Menu\n" +
                "--------------------------------\n");
        int id = validateInput(max);
        if (id == 0) {
            showMain();
        } else {
            Room room = Room.getByIdAndType(id, roomType);
            System.out.println("\n" + (room != null ? room : roomType + " with given id does NOT exist\n"));
            roomsMenu();
        }
    }

    private void createRoom() {
        System.out.println("--------------------------------\n" +
                "\tCREATE A NEW ROOM\n" +
                "\tWrite down the new room details\n");

        RoomType roomType = chooseRoomType();
        if (roomType == null) roomsMenu();

        String input = "";
        System.out.print("Provide volume of the room \n" +
                "(either a single value or three dimensions separated by whitespaces): ");
        String numPattern = "([1-9]\\d*(\\.\\d+)?|0\\.([1-9]|\\d{2,}))";
        String pattern = "^(" + numPattern + "|" + numPattern + "(\\s" + numPattern + "){2})$";
        Double[] volumeDouble = new Double[0];
        while (input.isEmpty() || !input.matches(pattern)) {
            if (input.equals("0")) {
                roomsMenu();
                break;
            }
            try {
                input = scanner.nextLine().trim();
                String[] volumeStr = input.split("\\s+");
                volumeDouble = Arrays.stream(volumeStr)
                        .map(Double::valueOf)
                        .toArray(Double[]::new);
            } catch (Exception e) {
                System.out.println("Incorrect input.");
            }
        }

        System.out.println("--------------------------------\n" +
                "\tCHOOSE HOUSING ESTATE ID\n" +
                "\tfrom the list below\n");
        for (HousingEstate estate : HousingEstate.getEstates())
            System.out.println("\t" + estate + "\n");
        System.out.println("\n--------------------------------\n");
        HousingEstate estate = null;
        boolean isValid = false;

        while(!isValid) {
            int id = validateInput(HousingEstate.getEstates().size());
            estate = HousingEstate.getById(id);
            if (estate == null) System.out.println("\nHousing Estate of id " + id + " does not exist.\n");
            else isValid = true;
        }

        Room room = null;
        try {
            if (roomType == RoomType.APARTMENT) {
                room = switch (volumeDouble.length) {
                    case 1 -> new Apartment(estate, volumeDouble[0]);
                    case 3 -> new Apartment(estate, volumeDouble[0], volumeDouble[1], volumeDouble[2]);
                    default -> null;
                };
            } else if (roomType == RoomType.PARKINGPLACE) {
                room = switch (volumeDouble.length) {
                    case 1 -> new ParkingPlace(estate, volumeDouble[0]);
                    case 3 -> new ParkingPlace(estate, volumeDouble[0], volumeDouble[1], volumeDouble[2]);
                    default -> null;
                };
            }
            System.out.println("--------------------------------\n" +
                    "\tEstate.Rooms.Room successfully created:");
            System.out.println("\t" + estate + ", " + room + "\n");
        } catch (Exception e) {
            System.out.println("\tEstate.Rooms.Room could not be created. Try again later.\n");
        }
        roomsMenu();
    }

    public void tenantsMenu() {
        System.out.println("\n--------------------------------\n" +
                "\tTENANTS\n" +
                "\tchoose desired option by writing down its number \n" +
                "--------------------------------\n" +
                "\t1. Show tenants\n" +
                "\t2. Find tenant by ID\n" +
                "\t3. Create a new tenant\n" +
                "\t0. Get back to Main Menu\n");

        int input = validateInput(3);

        switch (input) {
            case 1 -> showAllTenants();
            case 2 -> findTenantById();
            case 3 -> createTenant();
            case 0 -> showMain();
        }

    }

    private void showAllTenants() {
        System.out.println("\n--------------------------------\n\tLIST OF TENANTS \n\n");
            for (Person tenant : Person.getPeople()) {
                System.out.println("\t" + tenant + "\n");
                System.out.println("\t" + (tenant.getRooms().isEmpty() ? "No rooms rented." : "Estate.Rooms rented:") + "\n");
                for (Room room : tenant.getRooms())
                    System.out.println("\t" + room.getHousingEstate() + ", " + room);
                System.out.println("\tNumber of letters: " + tenant.getLetters().size() + "\n");
            }
        System.out.println("\n--------------------------------\n");
        tenantsMenu();
    }

    private void findTenantById() {
        System.out.println("\n--------------------------------\n");

        int max = Person.getPeople().size();
        System.out.println("\n--------------------------------\n" +
                "\tFIND TENANT BY ID\n" +
                "\tWrite down the ID number of a chosen tenant \n" +
                "\tor choose 0 to get back to Tenants Menu\n" +
                "--------------------------------\n");
        int id = validateInput(max);
        if (id == 0) {
            tenantsMenu();
        } else {
            Person tenant = Person.getById(id);
            System.out.println("\n--------------------------------\n" +
                    "\t" + (tenant != null ? tenant : "Tenants.Person with given id does NOT exist\n"));
            if (tenant != null) {
                System.out.println("\t" + (tenant.getRooms().isEmpty() ? "No rooms rented." : "Estate.Rooms rented:") + "\n");
                for (Room room : tenant.getRooms())
                    System.out.println("\t" + room.getHousingEstate() + ", " + room + "\n");
                System.out.println("\tNumber of letters: " + tenant.getLetters().size() + "\n");
            }
            System.out.println("\n--------------------------------\n");
            tenantsMenu();
        }
    }

    private void createTenant() {
        System.out.println("--------------------------------\n" +
                "\tCREATE A NEW TENANT\n" +
                "\tWrite down the new tenant details\n");

        String namePattern = "^[A-Za-z\\s'\\-]+$";
        String addressPattern = "^[A-Za-z0-9\\s,'\\.\\-]+$";
        String name = validateInputPattern("tenant", "name", namePattern);
        String surname = validateInputPattern("tenant", "surname", namePattern);
        String address = validateInputPattern("tenant", "address", addressPattern);

        Person tenant = null;
        try {
            tenant = new Person(name, surname, address);
            System.out.println("--------------------------------\n" +
                    "\tTenant successfully created:");
            System.out.println("\t" + tenant + "\n");
        } catch (Exception e) {
            System.out.println("\tTenant could not be created. Try again later.\n");
        }
        tenantsMenu();
    }

    public void itemsMenu() {
        System.out.println("\n--------------------------------\n" +
                "\tITEMS\n" +
                "\tchoose desired option by writing down its number \n" +
                "--------------------------------\n" +
                "\t1. Show items\n" +
                "\t2. Create a new item\n" +
                "\t3. Place item\n" +
                "\t4. Remove item\n" +
                "\t0. Get back to Main Menu\n");

        int input = validateInput(4);

        switch (input) {
            case 1 -> showAllItems();
            case 2 -> createItem();
            case 3 -> storeItem();
            case 4 -> removeItem();
            case 0 -> showMain();
        }

    }

    private void showAllItems() {

        System.out.println("\n--------------------------------\n" +
                "\tLIST OF ITEMS \n");
        for (Item item : Item.getItems())
            System.out.println("\t" + item + ", stored: " + (item.getPlace() == null ? "not" : item.getPlace()) + "\n");
        System.out.println("\n--------------------------------\n");
        itemsMenu();
    }

        private void createItem() {
            System.out.println("--------------------------------\n" +
                    "\t CREATE A NEW ITEM\n" +
                    "\t Write down the new Item data data\n" +
                    "\t or choose 0 to get back to Main Menu\n" +
                    "--------------------------------\n");

            String itemType = chooseItemType();
            if (itemType == null) showMain();

            String namePattern = "^[A-Za-z0-9\\s,'\\.\\-]+$";
            String name = validateInputPattern("item", "name", namePattern);

            String input = "";
            System.out.print("Provide volume of the item \n" +
                    "(either a single value or three dimensions separated by whitespaces): ");
            String numPattern = "([1-9]\\d*(\\.\\d+)?|0\\.([1-9]|\\d{2,}))";
            String pattern = "^(" + numPattern + "|" + numPattern + "(\\s" + numPattern + "){2})$";
            Double[] volumeDouble = new Double[0];
            while (input.isEmpty() || !input.matches(pattern)) {
                if (input.equals("0")) {
                    roomsMenu();
                    break;
                }
                try {
                    input = scanner.nextLine().trim();
                    String[] volumeStr = input.split("\\s+");
                    volumeDouble = Arrays.stream(volumeStr)
                            .map(Double::valueOf)
                            .toArray(Double[]::new);
                } catch (Exception e) {
                    System.out.println("Incorrect input.");
                }
            }

            if (input.equals("0")) itemsMenu();

            switch (itemType) {
                case "Vehicle" -> createVehicle(name, volumeDouble);
                case "Other" -> createOtherItem(name, volumeDouble);
            }
        }

        public void createOtherItem(String name, Double[] volumeDouble) {
            Item item;
            try {
                item = switch (volumeDouble.length) {
                    case 1 -> new Item(name, volumeDouble[0]);
                    case 3 -> new Item(name, volumeDouble[0], volumeDouble[1], volumeDouble[2]);
                    default -> null;
                };
                System.out.println("--------------------------------\n" +
                        "\tItems.Vehicles.Item successfully created:");
                System.out.println("\t" + item + "\n");
            } catch (Exception e) {
                System.out.println("\tItem could not be created. Try again later.\n");
            }
            itemsMenu();
        }

        public void createVehicle(String name, Double[] volumeDouble) {
        VehicleType vehicleType = chooseCarType();
        if (vehicleType == null) {
            itemsMenu();
        }

        EngineType engineType = chooseEngineType();
        if (engineType == null) {
            itemsMenu();
        }

        double engineCapacity = -1;
        boolean isValid = false;

        while (!isValid) {
            System.out.print("\tType down the engine capacity of the new vehicle: ");

            try {
                engineCapacity = scanner.nextDouble();

                if (engineCapacity >= 0) {
                    isValid = true;
                } else {
                    System.out.println("\n\tInput is out of range.\n");
                }
            } catch (Exception e) {
                System.out.println("\n\tInvalid input. Please enter a number.\n");
                scanner.nextLine();
            }
        }
        if (engineCapacity == 0) itemsMenu();

        String specificField = vehicleType.getSpecificField();
        String fieldValue = "";
        BoatType boatType = null;
        if (vehicleType == VehicleType.BOAT) {
            boatType = chooseBoatType();
        } else {
            String pattern = vehicleType.getPattern();
            fieldValue = validateInputPattern("vehicle", specificField, pattern);
        }

        if (fieldValue.equals("0")) {
            itemsMenu();
        }

        Vehicle vehicle = null;
        try {
            if (volumeDouble.length == 1) {
                vehicle = switch (vehicleType) {
                    case AMPHIBIOUS -> new Amphibious(name, engineCapacity, engineType, Integer.parseInt(specificField), volumeDouble[0]);
                    case BOAT -> new Boat(name, engineCapacity, engineType, boatType, volumeDouble[0]);
                    case CITY_CAR -> new CityCar(name, engineCapacity, engineType, Boolean.parseBoolean(specificField), volumeDouble[0]);
                    case MOTORCYCLE -> new Motorcycle(name, engineCapacity, engineType, Double.parseDouble(specificField), volumeDouble[0]);
                    case OFF_ROAD_CAR -> new OffRoadCar(name, engineCapacity, engineType, Double.parseDouble(specificField), volumeDouble[0]);
                };
            } else if (volumeDouble.length == 3) {
                vehicle = switch (vehicleType) {
                    case AMPHIBIOUS -> new Amphibious(name, engineCapacity, engineType, Integer.parseInt(specificField),
                            volumeDouble[0], volumeDouble[1], volumeDouble[2]);
                    case BOAT -> new Boat(name, engineCapacity, engineType, boatType,
                            volumeDouble[0], volumeDouble[1], volumeDouble[2]);
                    case CITY_CAR -> new CityCar(name, engineCapacity, engineType, Boolean.parseBoolean(specificField),
                            volumeDouble[0], volumeDouble[1], volumeDouble[2]);
                    case MOTORCYCLE -> new Motorcycle(name, engineCapacity, engineType, Double.parseDouble(specificField),
                            volumeDouble[0], volumeDouble[1], volumeDouble[2]);
                    case OFF_ROAD_CAR -> new OffRoadCar(name, engineCapacity, engineType, Double.parseDouble(specificField),
                            volumeDouble[0], volumeDouble[1], volumeDouble[2]);
                };
            }
            System.out.println("--------------------------------\n" +
                    "\tItems.Vehicles.Vehicle successfully created:");
            System.out.println("\t" + vehicle + "\n");
        } catch (Exception e) {
            System.out.println("\tVehicle could not be created. Try again later.\n");
        }


        itemsMenu();
    }

    public void storeItem() {
        System.out.println("--------------------------------\n" +
                "\tCHOOSE Parking Place ID to store the item\n" +
                "\tfrom the list below\n");

        System.out.println("\n--------------------------------\n" +
                "\tLIST OF PARKING PLACES \n");
        for (HousingEstate estate : HousingEstate.getEstates()) {
            for (Room room : Room.getByType(RoomType.PARKINGPLACE)) {
                ParkingPlace parkingPlace = (ParkingPlace) room;
                System.out.println(estate + ", " + parkingPlace);
            }
        }
        System.out.println("\n--------------------------------\n");

        ParkingPlace parkingPlace = null;
        boolean isValid = false;
        while(!isValid) {
            int id = validateInput(0);
            if (id == 0) itemsMenu();
            parkingPlace = (ParkingPlace) Room.getByIdAndType(id, RoomType.PARKINGPLACE);
            if (parkingPlace == null) System.out.println("\nParking Place of id " + id + " does not exist. Try again.\n");
            else isValid = true;
        }

        System.out.println("\n--------------------------------\n" +
                "\tLIST OF NOT STORED ITEMS \n");
        List<Item> notStoredItems = Item.getItems().stream()
                .filter(item -> item.getPlace() == null)
                .collect(Collectors.toList());

        for (Item item : notStoredItems)
            System.out.println("\t" + item);
        System.out.println("\n--------------------------------\n");

        Item item = null;
        isValid = false;
        while(!isValid) {
            int id = validateInput(0);
            if (id == 0) itemsMenu();
            item = Item.getById(id);
            if (item == null) System.out.println("\nItem of id " + id + " does not exist.\n");
            else isValid = true;
        }

        try {
            parkingPlace.takeIn(item);
            System.out.println("\nItem " + item.getName() + " successfully stored in chosen location.\n");
        } catch (Exception e) {
            System.out.println(e);
        }

        itemsMenu();
    }

    public void removeItem() {
        System.out.println("\n--------------------------------\n" +
                "\tChoose Item to remove from the parking place\n" +
                "\tLIST OF STORED ITEMS \n");
        List<Item> storedItems = Item.getItems().stream()
                .filter(item -> item.getPlace() != null)
                .collect(Collectors.toList());
        for (Item item : storedItems)
            System.out.println("\t" + item + ", stored: " + (item.getPlace() == null ? "not" : item.getPlace()) + "\n");
        System.out.println("\n--------------------------------\n");

        Item item = null;
        Boolean isValid = false;
        while(!isValid) {
            int id = validateInput(0);
            if (id == 0) itemsMenu();
            item = Item.getById(id);
            if (item == null) System.out.println("\nItem of id " + id + " does not exist.\n");
            else isValid = true;
        }

        try {
            item.getPlace().takeOut(item);
            System.out.println("\nItem " + item.getName() + " successfully taken out.\n");
        } catch (Exception e) {
            System.out.println(e);
        }

        itemsMenu();
    }

    public void rentsMenu() {
        System.out.println("\n--------------------------------\n" +
                "\tRENTS\n" +
                "\tchoose desired option by writing down its number \n" +
                "--------------------------------\n" +
                "\t1. Show all rents\n" +
                "\t2. Check Person In\n" +
                "\t3. Check Person Out\n" +
                "\t4. End rent\n" +
                "\t5. Prolong rent\n" +
                "\t0. Get back to Main Menu\n");

        int input = validateInput(5);

        switch (input) {
            case 1 -> showAllRents();
            case 2 -> checkPersonIn();
            case 3 -> checkPersonOut();
            case 4 -> endRent();
            case 5 -> prolongRent();
            case 0 -> showMain();
        }

    }

    public void checkPersonIn() {
        System.out.println("--------------------------------\n" +
                "\tCHOOSE Person ID to check in\n" +
                "\tfrom the list below\n");

        System.out.println("\n--------------------------------\n\tLIST OF TENANTS \n\n");
        for (Person tenant : Person.getPeople()) {
            System.out.println("\t" + tenant + "\n");
            System.out.println("\t" + (tenant.getRooms().isEmpty() ? "No rooms rented." : "Rooms rented:") + "\n");
            for (Room room : tenant.getRooms())
                System.out.println("\t" + room.getHousingEstate() + ", " + room + "\n");
            System.out.println("\tNumber of letters: " + tenant.getLetters().size() + "\n\n");
        }
        System.out.println("\n--------------------------------\n");

        Person person = null;
        boolean isValid = false;
        while(!isValid) {
            int id = validateInput(0);
            if (id == 0) rentsMenu();
            person = Person.getById(id);
            if (person == null) System.out.println("\nPerson of id " + id + " does not exist. Try again.\n");
            else isValid = true;
        }

        RoomType roomType = chooseRoomType();
        if (roomType == null) roomsMenu();

        System.out.println("\n--------------------------------\n" +
                "\tLIST OF CHOSEN ROOMS \n");
        for (HousingEstate estate : HousingEstate.getEstates()) {
            for (Room room : estate.getRooms(roomType))
                System.out.println(estate + ", " + room);
        }
        System.out.println("\n--------------------------------\n");

        Room room = null;
        isValid = false;
        while(!isValid) {
            int id = validateInput(0);
            if (id == 0) rentsMenu();
            room = Room.getByIdAndType(id, roomType);
            if (room == null) System.out.println("\nChosen typeof room of id " + id + " does not exist. Try again.\n");
            else if (room.isRented() && roomType == RoomType.PARKINGPLACE)
                System.out.println("\nThis Parking Place has already been rented. Choose another one.\n");
            else isValid = true;
        }

        if (!room.isRented()) {
            System.out.println("\nRoom has not been rented yet. You need to start a new rent.\n");
            startNewRent(room, roomType, person);
        }

        try {
            Apartment apt = (Apartment) room;
            apt.checkIn(person);
            System.out.println("\nPerson " + person.getFullName() + " successfully checked in to " + apt +".\n");
        } catch (Exception e) {
            System.out.println(e);
        }

        rentsMenu();
    }

    public void startNewRent(Room room, RoomType roomType, Person person) {
        String datePattern = "^[0-9]{4}-[0-9]{2}-[0-9]{2}$";
        String startDate = validateInputPattern("rent", "start date (expected format: yyyy-MM-dd)", datePattern);
        String endDate = validateInputPattern("rent", "end date (expected format: yyyy-MM-dd)", datePattern);

        Rent rent = null;
        try {
            rent = new Rent(person, startDate, endDate, room);
            System.out.println("--------------------------------\n" +
                    "\tNew rent successfully created:");
            System.out.println("\t" + rent + "\n");
        } catch (Exception e) {
            System.out.println("\tRent could not be created. Try again later.\n");
        }
        rentsMenu();

    }

    public void checkPersonOut() {
        System.out.println("\n--------------------------------\n" +
                "\tChoose Tenants.Person to remove from the apartment\n" +
                "\tLIST OF CHECKED IN \n");
        List<Person> checkedIn = Person.getPeople().stream()
                .filter(person -> !person.getRooms().isEmpty())
                .collect(Collectors.toList());
        for (Person person : checkedIn) {
            System.out.println("\t" + person.getFullName() + ":\n");
            for (Room room : person.getRooms())
                System.out.println(room);
        }
        System.out.println("\n--------------------------------\n");

        Person person = null;
        boolean isValid = false;
        while(!isValid) {
            int id = validateInput(0);
            if (id == 0) rentsMenu();
            person = Person.getById(id);
            if (person == null) System.out.println("\nItem of id " + id + " does not exist.\n");
            else isValid = true;
        }

        System.out.println("\n--------------------------------\n" +
                "\tChoose Room to remove the person from\n" +
                "\tLIST OF ROOMS\n");
        List<Room> rooms = person.getRooms().stream()
                .filter(r -> r.getRoomType() == RoomType.APARTMENT)
                .collect(Collectors.toList());
        for (Room room : rooms) {
            System.out.println("\t" + room);
        }
        System.out.println("\n--------------------------------\n");

        Room room = null;
        isValid = false;
        while(!isValid) {
            int id = validateInput(0);
            if (id == 0) rentsMenu();
            room = Room.getByIdAndType(id, RoomType.APARTMENT);
            if (room == null) System.out.println("\nItem of id " + id + " does not exist.\n");
            else isValid = true;
        }

        try {
            Apartment apt = (Apartment) room;
            System.out.println("\n" + person + " successfully removed from " + apt + "\n");
        } catch (Exception e) {
            System.out.println(e);
        }

        rentsMenu();
    }

    private void showAllRents() {
        System.out.println("\n--------------------------------\n" +
                "\tLIST OF ACTIVE RENTS \n");
        List<Rent> rents = Rent.getRents().stream()
                .filter(r -> !r.checkDate())
                .collect(Collectors.toList());
        for (Rent rent : rents)
            System.out.println("\t" + rent + "\n");
        System.out.println("\n--------------------------------\n");
        rentsMenu();
    }

    private void prolongRent() {
        System.out.println("\n--------------------------------\n" +
                "\tLIST OF RENTS TO BE PROLONGED \n");
        List<Rent> rents = Rent.getRents().stream()
                .filter(r -> (r.isEnded() && !r.check30DaysAfter()))
                .collect(Collectors.toList());
        for (Rent rent : rents)
            System.out.println("\t" + rent + "\n");
        System.out.println("\n--------------------------------\n");

        if (rents.isEmpty()) {
            System.out.println("\nNo rents to prolong\n");
            rentsMenu();
        }

        Rent rent = null;
        boolean isValid = false;
        while(!isValid) {
            int id = validateInput(0);
            if (id == 0) rentsMenu();
            rent = Rent.getById(id);
            if (rent == null) System.out.println("\nRent of id " + id + " does not exist.\n");
            else isValid = true;
        }

        String datePattern = "^[0-9]{4}-[0-9]{2}-[0-9]{2}$";
        String endDate = validateInputPattern("end date", "info (expected format: yyyy-MM-dd)", datePattern);

        try {
            rent.prolongRent(endDate);
            System.out.println("\n" + rent + " successfully prolonged\n");
        } catch (Exception e) {
            System.out.println(e);
        }

        rentsMenu();
    }

    private void endRent() {
        System.out.println("\n--------------------------------\n" +
                "\tLIST OF RENTS TO BE PROLONGED \n");
        List<Rent> rents = Rent.getRents().stream()
                .filter(r -> (!r.check30DaysAfter()))
                .collect(Collectors.toList());
        for (Rent rent : rents)
            System.out.println("\t" + rent + "\n");
        System.out.println("\n--------------------------------\n");

        Rent rent = null;
        boolean isValid = false;
        while(!isValid) {
            int id = validateInput(0);
            if (id == 0) rentsMenu();
            rent = Rent.getById(id);
            if (rent == null) System.out.println("\nRent of id " + id + " does not exist.\n");
            else isValid = true;
        }

        try {
            rent.finalTerminate();
            System.out.println("\n" + rent + " successfully terminated\n");
        } catch (Exception e) {
            System.out.println(e);
        }

        rentsMenu();
    }

    public void generateReportMenu() {
        System.out.println("--------------------------------\n" +
                "\t GENERATE A STATUS\n" +
                "\t To generate a status type down the ID number of a chosen HousingEstate \n");

        System.out.println("\n" +
                "\tLIST OF HOUSING ESTATES \n");
        for (HousingEstate estate : HousingEstate.getEstates())
            System.out.println(estate);
        System.out.println("\n--------------------------------\n");
        int id = validateInput(HousingEstate.getEstates().size());
        if (id == 0) showMain();
        HousingEstate estate = HousingEstate.getById(id);
            try {
                new Status(estate);
                System.out.println("\n\tNew status successfully generated.");
            } catch (Exception e) {
                System.out.println("\n\trents.Status could not be generated.");
            }
        showMain();
    }

    @Override
    public void run() {
        try {
            showMain();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
