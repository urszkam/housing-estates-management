import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Stream;

public class Menu implements Runnable{
    private Scanner scanner;
    public Menu() {
        scanner = new Scanner(System.in);
        new Thread(this).start();
    }

    public void showMain() {
        System.out.println("--------------------------------\n" +
                "\t MENU\n" +
                "choose desired option by writing down its number \n" +
                "--------------------------------\n" +
                "\t1. Housing Estates\n" +
                "\t2. Rooms\n" +
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
//            case 3 -> tenantsMenu();
//            case 4 -> itemsMenu();
//            case 5 -> rentsMenu();
//            case 6 -> generateReportMenu();
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
                "\tLIST OF HOUSING ESTATES \n" +
                "--------------------------------\n");
        for (HousingEstate estate : HousingEstate.getEstates())
            System.out.println(estate);

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
        createHousingEstate();
    }

    public void roomsMenu() {
        System.out.println("\n--------------------------------\n" +
                "\tRooms\n" +
                "\tchoose desired room type by writing down its number \n" +
                "--------------------------------\n" +
                "\t1. Apartments\n" +
                "\t2. Parking Places\n" +
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
            case 1 -> apartmentsMenu();
//            case 2 -> parkingPlacesMenu();
            case 0 -> showMain();
        }
    }

//        int cars = -1;
//        boolean isValid = false;
//        while (!isValid) {
//            System.out.print("Write down the number of total cars that can be connected to the locomotive.\n");
//            System.out.print("Choose between " + 1 + " and " + 10 + ": ");
//            try {
//                cars = scanner.nextInt();
//                if (cars == 0) {
//                    locomotivesMenu();
//                    break;
//                }
//                if (cars >= 1 && cars <= 10) {
//                    isValid = true;
//                } else {
//                    System.out.println("Input is out of range.");
//                }
//            } catch (Exception e) {
//                System.out.println("Invalid input. Please enter an integer.");
//                scanner.nextLine();
//            }
//        }
//        int electricCars = -1;
//        isValid = false;
//        while (!isValid) {
//            System.out.print("Write down the number of electric cars that can be connected to the locomotive.\n");
//            System.out.print("Choose between " + 0 + " and " + cars + ": ");
//            try {
//                electricCars = scanner.nextInt();
//                if (cars < electricCars) {
//                    locomotivesMenu();
//                    break;
//                }
//                else if (electricCars >= 0 && electricCars <= cars) {
//                    isValid = true;
//                } else {
//                    System.out.println("Input is out of range.");
//                }
//            } catch (Exception e) {
//                System.out.println("Invalid input. Please enter an integer.");
//                scanner.nextLine();
//            }
//        }
//
//        int load = -1;
//        isValid = false;
//        while (!isValid) {
//            System.out.print("Write down the max weight of load in kg.");
//            System.out.print("Choose between " + 1000 + " and " + 50000 + ": ");
//            try {
//                load = scanner.nextInt();
//                if (load == 0) {
//                    System.out.println("Weight cannot be lower than 0.");
//                }
//                else if (load >= 1000 && load <= 50000) {
//                    isValid = true;
//                } else {
//                    System.out.println("Input is out of range.");
//                }
//            } catch (Exception e) {
//                System.out.println("Invalid input. Please enter an integer.");
//                scanner.nextLine();
//            }
//        }
//    private void showConnectedLoc() {
//        System.out.println("--------------------------------\n" +
//                "\t LIST OF CONNECTED LOCOMOTIVES \n" +
//                "--------------------------------\n");
//        for (Locomotive loc : Locomotive.getLocomotives()) {
//            if (!loc.isAvailable) {
//                System.out.println(loc);
//            }
//        }
//
//        locomotivesMenu();
//    }


    public void apartmentsMenu() {
        System.out.println("\n--------------------------------\n" +
                "\tApartments\n" +
                "\tchoose desired option by writing down its number \n" +
                "--------------------------------\n" +
                "\t1. Show all apartments\n" +
                "\t2. Show apartment\n" +
                "\t3. Add tenant to apartment\n" +
                "\t4. Remove tenant from apartment\n" +
                "\t5. Add item to apartment\n" +
                "\t6. Remove item from apartment\n" +
                "\t7. Add Apartment to Housing Estate\n" +
                "\t8. Remove Apartment from Housing Estate\n" +
                "\t9. Create new Apartment\n" +
                "\t0. Get back to Main Menu\n");

        int input = -1;
        boolean isValid = false;
        while (!isValid) {
            System.out.print("Choose option between " + 0 + " and " + 9 + ": ");
            try {
                input = scanner.nextInt();
                if (input >= 0 && input <= 9) {
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
            case 1 -> showAllAparts();
            case 2 -> findApartById();
//            case 3 -> addTenantToApart();
//            case 4 -> removeTenantFromApart();
//            case 5 -> addItemToApart();
//            case 6 -> removeItemFromApart();
            case 7 -> addApartToEstate();
//            case 8 -> removeApartFromEstate();
            case 9 -> createApartment();
            case 0 -> showMain();
        }

    }

    private void showAllAparts() {
        System.out.println("\n--------------------------------\n" +
                "\tLIST OF APARTMENTS \n" +
                "--------------------------------\n");
        for (HousingEstate estate : HousingEstate.getEstates()) {
            for (Apartment apart : estate.getApartments())
                System.out.println(apart);
        }

        apartmentsMenu();
    }

    private int validateInput() {
        int input = -1;
        boolean isValid = false;
        while (!isValid) {
            System.out.print("Choose option by typing down its number or type 0 to get back to menu:");
            try {
                input = scanner.nextInt();
                if (input >= 0) {
                    isValid = true;
                } else {
                    System.out.println("Input is out of range.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.nextLine();
            }
        }
        return input;
    }

    private void findApartById() {
        int max = Apartment.getApartments().size();
        System.out.println("\n--------------------------------\n" +
                "\tFIND APARTMENT BY ID\n" +
                "\tWrite down the ID number of a chosen Apartment \n" +
                "\tor choose 0 to get back to Main Menu\n" +
                "--------------------------------\n");
        int id = -1;
        boolean isValid = false;
        while (!isValid) {
            System.out.print("Choose option between " + 0 + " and " + max + ": ");
            try {
                id = scanner.nextInt();
                if (id >= 0) {
                    isValid = true;
                } else {
                    System.out.println("Input is out of range.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.nextLine();
            }
        }
        if (id == 0) {
            showMain();
        } else {
            Apartment apart = (Apartment) Room.getByIdAndType(id, RoomType.APARTMENT);
            System.out.println(apart != null ? apart : "Apartment with given id does NOT exist");
            findApartById();
        }
    }

//    public static Room findRoom(Integer id, RoomType roomType) {
//        Optional<? extends Room> optionalRoom = Optional.empty();
//        optionalRoom = Optional.ofNullable(Room.getById(id));
//        if (roomType == RoomType.APARTMENT)
//
//        else if (roomType == RoomType.PARKINGPLACE)
//            optionalRoom = ParkingPlace.getPlaces().stream()
//                    .filter(room -> room.getId() == id).findFirst();
//        if (optionalRoom.isPresent()) {
//            return optionalRoom.get();
//        } else {
//            return null;
//        }
//    }

    private void createApartment() {
        System.out.println("--------------------------------\n" +
                "\tCREATE A NEW APARTMENT\n" +
                "\tWrite down the new apartment details\n" +
                "\tor choose 0 to get back to Apartments Menu\n" +
                "--------------------------------\n");

        String input = "";
        System.out.print("Provide volume of the apartment \n" +
                "(either a single value or three dimensions separated by whitespaces): ");
        String numPattern = "([1-9]\\d*(\\.\\d+)?|0\\.([1-9]|\\d{2,}))";
        String pattern = "^(" + numPattern + "|" + numPattern + "(\\s" + numPattern + "){2})$";
        Double[] volumeDouble = new Double[0];
        while (input.isEmpty() || !input.matches(pattern)) {
            if (input.equals("0")) {
                apartmentsMenu();
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
            System.out.println(estate);
        System.out.println( "--------------------------------");

        int id = -1;
        boolean isValid = false;
        HousingEstate estate = null;
        while (!isValid) {
            System.out.print("Choose housing estate's ID or 0 to get back to Main Menu: ");
            try {
                id = scanner.nextInt();
                if (id == 0) {
                    showMain();
                    return;
                } else if (id >= 0) {
                    estate = HousingEstate.getById(id);
                    if (estate != null) isValid = true;
                    else System.out.println("Housing Estate of id " + id + " does not exist.");
                } else {
                    System.out.println("Input is out of range.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.nextLine();
            }
        }

        try {
            Apartment apart = switch (volumeDouble.length) {
                case 1 -> new Apartment(estate, volumeDouble[0]);
                case 3 -> new Apartment(estate, volumeDouble[0], volumeDouble[1], volumeDouble[2]);
                default -> null;
            };
            System.out.println("Apartment successfully created:");
            System.out.println(apart);
        } catch (Exception e) {
            System.out.println("Apartment could not be created. Try again later.");
        }
    };

    private void addApartToEstate() {

    }


//    private void removeCargo() {
//        System.out.println("--------------------------------\n" +
//                "\t REMOVE CARGO \n" +
//                "\t Choose which cargo you want to remove\n" +
//                "\t or choose 0 to get back to Main Menu\n" +
//                "--------------------------------\n");
//
//        System.out.println("\tCHOOSE CARGO TYPE\n" +
//                "\t 1. Passengers\n" +
//                "\t 2. Baggage\n" +
//                "\t 3. Gas\n" +
//                "\t 4. Liquid\n" +
//                "\t 5. Mail\n" +
//                "\t 6. Food\n" +
//                "\t 7. Frozen\n" +
//                "\t 8. Explosives\n" +
//                "\t 9. Toxic Materials\n" +
//                "\t 10. Liquid&Toxic Materials\n" +
//                "--------------------------------\n");
//        int input = -1;
//        boolean isValid = false;
//        while (!isValid) {
//            System.out.print("Choose option between " + 0 + " and " + 10 + ": ");
//            try {
//                input = scanner.nextInt();
//                if (input >= 0 && input <= 10) {
//                    isValid = true;
//                } else {
//                    System.out.println("Input is out of range.");
//                }
//            } catch (Exception e) {
//                System.out.println("Invalid input. Please enter an integer.");
//                scanner.nextLine();
//            }
//        }
//
//        if (input == 0) {
//            railroadCarsMenu();
//        }
//
//        CargoType type = switch (input) {
//            case 1 -> CargoType.PASSENGERS;
//            case 2 -> CargoType.BAGGAGE;
//            case 3 -> CargoType.GAS;
//            case 4 -> CargoType.LIQUID;
//            case 5 -> CargoType.MAIL;
//            case 6 -> CargoType.FOOD;
//            case 7 -> CargoType.FROZEN;
//            case 8 -> CargoType.EXPLOSIVES;
//            case 9 -> CargoType.TOXIC;
//            case 10 -> CargoType.TOXICLIQUID;
//            default -> null;
//        };
//
//        System.out.println("--------------------------------\n" +
//                "\t LIST OF CARS WITH THAT TYPE OF CARGO:\n" +
//                "--------------------------------\n");
//        for (RailroadCar car : RailroadCar.getCars()) {
//            if (car.getCargoType() == type && !car.getCargos().isEmpty()) {
//                System.out.println(car);
//            }
//        }
//
//        System.out.println("If the list is empty - no car is loaded with that type of cargo.\n" +
//                "Please choose 0 to get back to menu\n");
//
//        int car = -1;
//        isValid = false;
//        RailroadCar carObj = null;
//        while (!isValid) {
//            System.out.print("Write down the railroad car's id from the list above.\n");
//            try {
//                car = scanner.nextInt();
//                if (car == 0) {
//                    railroadCarsMenu();
//                    break;
//                }
//                if (car > 0) {
//                    carObj = findCar(car);
//                    if (carObj == null) {
//                        System.out.println("No car with a given id.");
//                        continue;
//                    } else if (carObj.getCargoType() != type || carObj.getCargos().isEmpty()) {
//                        System.out.println("Car with chosen id doesn't contain that type of cargo.");
//                    } else {
//                        isValid = true;
//                    }
//                } else {
//                    System.out.println("Input is out of range.");
//                }
//            } catch (Exception e) {
//                System.out.println("Invalid input. Please enter an integer.");
//                scanner.nextLine();
//            }
//        }
//
//        try {
//            carObj.removeCargo();
//        } catch (Exception e) {
//            System.out.println(e + " Cargo cannot be removed.");
//        }
//
//        railroadCarsMenu();
//
//
//    }
//
//    private void addCargo() {
//        System.out.println("--------------------------------\n" +
//                "\t Create a new Cargo \n" +
//                "\t Write down the new connection data\n" +
//                "\t or choose 0 to get back to Main Menu\n" +
//                "--------------------------------\n");
//
//        System.out.println("\tCHOOSE CARGO TYPE\n" +
//                "\t 1. Passengers\n" +
//                "\t 2. Baggage\n" +
//                "\t 3. Gas\n" +
//                "\t 4. Liquid\n" +
//                "\t 5. Mail\n" +
//                "\t 6. Food\n" +
//                "\t 7. Frozen\n" +
//                "\t 8. Explosives\n" +
//                "\t 9. Toxic Materials\n" +
//                "\t 10. Liquid&Toxic Materials\n" +
//                "--------------------------------\n");
//        int input = -1;
//        boolean isValid = false;
//        while (!isValid) {
//            System.out.print("Choose option between " + 0 + " and " + 10 + ": ");
//            try {
//                input = scanner.nextInt();
//                if (input >= 0 && input <= 10) {
//                    isValid = true;
//                } else {
//                    System.out.println("Input is out of range.");
//                }
//            } catch (Exception e) {
//                System.out.println("Invalid input. Please enter an integer.");
//                scanner.nextLine();
//            }
//        }
//
//        if (input == 0) {
//            railroadCarsMenu();
//        }
//
//        int weight = -1;
//        isValid = false;
//        while (!isValid) {
//            System.out.println("Choose weight of the cargo in kg or number of passengers: ");
//            try {
//                weight = scanner.nextInt();
//                if (weight > 0) {
//                    isValid = true;
//                } else {
//                    System.out.println("Input is out of range.");
//                }
//            } catch (Exception e) {
//                System.out.println("Invalid input. Please enter an integer.");
//                scanner.nextLine();
//            }
//        }
//
//        Cargo cargoObj = switch (input) {
//            case 1 -> new Passengers(weight);
//            case 2 -> new Cargo(weight, CargoType.BAGGAGE);
//            case 3 -> new Cargo(weight, CargoType.GAS);
//            case 4 -> new Cargo(weight, CargoType.LIQUID);
//            case 5 -> new Cargo(weight, CargoType.MAIL);
//            case 6 -> new Cargo(weight, CargoType.FOOD);
//            case 7 -> new Cargo(weight, CargoType.FROZEN);
//            case 8 -> new Cargo(weight, CargoType.EXPLOSIVES);
//            case 9 -> new Cargo(weight, CargoType.TOXIC);
//            case 10 -> new Cargo(weight, CargoType.TOXICLIQUID);
//            default -> null;
//        };
//
//        CargoType type = switch (input) {
//            case 1 -> CargoType.PASSENGERS;
//            case 2 -> CargoType.BAGGAGE;
//            case 3 -> CargoType.GAS;
//            case 4 -> CargoType.LIQUID;
//            case 5 -> CargoType.MAIL;
//            case 6 -> CargoType.FOOD;
//            case 7 -> CargoType.FROZEN;
//            case 8 -> CargoType.EXPLOSIVES;
//            case 9 -> CargoType.TOXIC;
//            case 10 -> CargoType.TOXICLIQUID;
//            default -> null;
//        };
//
//        System.out.println("--------------------------------\n" +
//                "\t LIST OF AVAILABLE CARS FOR THIS TYPE OF CARGO:\n" +
//                "--------------------------------\n");
//        for (RailroadCar car : RailroadCar.getCars()) {
//            if (car.getCargoType() == type) {
//                System.out.println(car);
//            }
//        }
//
//        System.out.println("If the list is empty - no available car for this type of cargo.\n" +
//                "Please choose 0 to get back to create a new car for this type of cargo\n");
//
//        int car = -1;
//        isValid = false;
//        RailroadCar carObj = null;
//        while (!isValid) {
//            System.out.print("Write down the railroad car's id from the list above.\n");
//            try {
//                car = scanner.nextInt();
//                if (car == 0) {
//                    railroadCarsMenu();
//                    break;
//                }
//                if (car > 0) {
//                    carObj = findCar(car);
//                    if (carObj == null) {
//                        System.out.println("No car with a given id.");
//                        continue;
//                    } else if (carObj.getCargoType() != type) {
//                        System.out.println("Car with chosen id cannot load this type of cargo.");
//                    } else {
//                        isValid = true;
//                    }
//                } else {
//                    System.out.println("Input is out of range.");
//                }
//            } catch (Exception e) {
//                System.out.println("Invalid input. Please enter an integer.");
//                scanner.nextLine();
//            }
//        }
//
//        try {
//            carObj.addCargo(cargoObj);
//            System.out.println("Cargo successfully added");
//        } catch (Exception e) {
//            System.out.println(e + " Cargo cannot be added.");
//        }
//
//        railroadCarsMenu();
//
//
//    }
//
//    private void createCar() {
//        System.out.println("--------------------------------\n" +
//                "\t Create a new RailroadCar \n" +
//                "\t Write down the new Railroad Car data\n" +
//                "\t or choose 0 to get back to Main Menu\n" +
//                "--------------------------------\n");
//
//        System.out.println("\tCHOOSE CAR TYPE\n" +
//                "\t 1. Passenger Railroad Car\n" +
//                "\t 2. Baggage or Mail Car\n" +
//                "\t 3. Gas Car\n" +
//                "\t 4. Liquid Car\n" +
//                "\t 5. Post Office\n" +
//                "\t 6. Restaurant Car\n" +
//                "\t 7. Refrigerated Car\n" +
//                "\t 8. Explosives Car\n" +
//                "\t 9. Toxic Materials Car\n" +
//                "\t 10. Liquid&Toxic Materials Car\n" +
//                "--------------------------------\n");
//
//        int input = -1;
//        boolean isValid = false;
//        while (!isValid) {
//            System.out.print("Choose option between " + 0 + " and " + 10 + ": ");
//            try {
//                input = scanner.nextInt();
//                if (input >= 0 && input <= 10) {
//                    isValid = true;
//                } else {
//                    System.out.println("Input is out of range.");
//                }
//            } catch (Exception e) {
//                System.out.println("Invalid input. Please enter an integer.");
//                scanner.nextLine();
//            }
//        }
//
//        if (input == 0) {
//            railroadCarsMenu();
//        }
//
//        int weight = -1;
//        isValid = false;
//        while (!isValid) {
//            System.out.print("Choose weight of the car in kg: ");
//            try {
//                weight = scanner.nextInt();
//                if (weight > 0) {
//                    isValid = true;
//                } else {
//                    System.out.println("Input is out of range.");
//                }
//            } catch (Exception e) {
//                System.out.println("Invalid input. Please enter an integer.");
//                scanner.nextLine();
//            }
//        }
//
//        if (input == 0) {
//            railroadCarsMenu();
//        }
//
//        RailroadCar carObj = switch (input) {
//            case 1 -> new PassengerRailroadCar(weight);
//            case 2 -> new BaggageMail(weight);
//            case 3 -> new GasCar(weight);
//            case 4 -> new LiquidCar(weight);
//            case 5 -> new PostOffice(weight);
//            case 6 -> new RestaurantCar(weight);
//            case 7 -> new RefrigeratedCar(weight);
//            case 8 -> new ExplosivesCar(weight);
//            case 9 -> new ToxicCar(weight);
//            case 10 -> new LiquidToxicCar(weight);
//            default -> null;
//        };
//        try {
//            System.out.println(carObj);
//        } catch (Exception e) {
//            System.out.println("Car cannot be created");
//        }
//        railroadCarsMenu();
//    }
//
//
//    private void disconnectCar() {
//        int maxCar = RailroadCar.getCars().size();
//        int maxSet = TrainSet.getTrainsets().size();
//        System.out.println("--------------------------------\n" +
//                "\t REMOVE RAILROAD CAR FROM A TRAINSET \n" +
//                "\t Write down the data necessary to remove the car.\n" +
//                "\t or choose 0 to get back to Main Menu\n" +
//                "--------------------------------\n");
//
//        int set = -1;
//        boolean isValid = false;
//        while (!isValid) {
//            System.out.print("Write down the trainset's id.\n");
//            System.out.print("Choose id between " + 1 + " and " + maxSet + ": ");
//            try {
//                set = scanner.nextInt();
//                if (set == 0) {
//                    railroadCarsMenu();
//                    break;
//                }
//                if (set >= 1 && set <= maxSet) {
//                    isValid = true;
//                } else {
//                    System.out.println("Input is out of range.");
//                }
//            } catch (Exception e) {
//                System.out.println("Invalid input. Please enter an integer.");
//                scanner.nextLine();
//            }
//        }
//
//        int car = -1;
//        isValid = false;
//        RailroadCar carObj = null;
//        while (!isValid) {
//            System.out.print("Write down the railroad car's id.\n");
//            System.out.print("Choose id between " + 1 + " and " + maxCar + ": ");
//            try {
//                car = scanner.nextInt();
//                if (car == 0) {
//                    railroadCarsMenu();
//                    break;
//                }
//                if (car >= 1 && car <= maxCar) {
//                    carObj = findCar(car);
//                    if (carObj == null) {
//                        System.out.println("Car with a given id doesn't exist.");
//                        continue;
//                    } else if (carObj.isAvailable) {
//                        System.out.println("Car already disconnected.");
//                    } else {
//                        isValid = true;
//                    }
//                } else {
//                    System.out.println("Input is out of range.");
//                }
//            } catch (Exception e) {
//                System.out.println("Invalid input. Please enter an integer.");
//                scanner.nextLine();
//            }
//        }
//
//        try {
//            TrainSet setObj = findTrainset(set);
//            setObj.removeRailroadCar(carObj);
//            System.out.println("Car successfully disconnected.");
//        } catch (Exception e) {
//            System.out.println(e + " Car cannot be disconnected.");
//        }
//
//        railroadCarsMenu();
//    }
//
//    private void connectCar() {
//        int maxCar = RailroadCar.getCars().size();
//        int maxSet = TrainSet.getTrainsets().size();
//        System.out.println("--------------------------------\n" +
//                "\t ADD RAILROAD CAR TO A TRAINSET \n" +
//                "\t Write down the data necessary to connect the car.\n" +
//                "\t or choose 0 to get back to Main Menu\n" +
//                "--------------------------------\n");
//
//        int set = -1;
//        boolean isValid = false;
//        while (!isValid) {
//            System.out.print("Write down the trainset's id.\n");
//            System.out.print("Choose id between " + 1 + " and " + maxSet + ": ");
//            try {
//                set = scanner.nextInt();
//                if (set == 0) {
//                    railroadCarsMenu();
//                    break;
//                }
//                if (set >= 1 && set <= maxSet) {
//                    isValid = true;
//                } else {
//                    System.out.println("Input is out of range.");
//                }
//            } catch (Exception e) {
//                System.out.println("Invalid input. Please enter an integer.");
//                scanner.nextLine();
//            }
//        }
//
//        int car = -1;
//        isValid = false;
//        RailroadCar carObj = null;
//        while (!isValid) {
//            System.out.print("Write down the railroad car's id.\n");
//            System.out.print("Choose id between " + 1 + " and " + maxCar + ": ");
//            try {
//                car = scanner.nextInt();
//                if (car == 0) {
//                    railroadCarsMenu();
//                    break;
//                }
//                if (car >= 1 && car <= maxCar) {
//                    carObj = findCar(car);
//                    if (carObj == null) {
//                        continue;
//                    } else if (!carObj.isAvailable) {
//                        System.out.println("Car already connected.");
//                    } else {
//                        isValid = true;
//                    }
//                } else {
//                    System.out.println("Input is out of range.");
//                }
//            } catch (Exception e) {
//                System.out.println("Invalid input. Please enter an integer.");
//                scanner.nextLine();
//            }
//        }
//
//        try {
//            TrainSet setObj = findTrainset(set);
//            setObj.addRailroadCar(carObj);
//        } catch (Exception e) {
//            System.out.println(e + " Car cannot be connected.");
//        }
//        railroadCarsMenu();
//    }
//
//    private void showConnectedCars() {
//        System.out.println("--------------------------------\n" +
//                "\t LIST OF CARS CONNECTED TO LOCOMOTIVES \n" +
//                "--------------------------------\n");
//        for (RailroadCar car : RailroadCar.getCars()) {
//            if (!car.isAvailable) {
//                System.out.println(car);
//            }
//        }
//
//        railroadCarsMenu();
//    }
//
//    private void showAvailableCars() {
//        System.out.println("--------------------------------\n" +
//                "\t LIST CARS AVAILABLE CARS \n" +
//                "--------------------------------\n");
//        for (RailroadCar car : RailroadCar.getCars()) {
//            if (car.isAvailable) {
//                System.out.println(car);
//            }
//        }
//
//        railroadCarsMenu();
//    }
//
//    public void stationsMenu() {
//        System.out.println("--------------------------------\n" +
//                "\t Stations\n" +
//                "choose desired option by writing down its number \n" +
//                "--------------------------------\n" +
//                "\t1. Find station by id\n" +
//                "\t2. Show existing stations\n" +
//                "\t3. Create a new station\n" +
//                "\t0. Get back to Main Menu\n");
//        int input = -1;
//        boolean isValid = false;
//        while (!isValid) {
//            System.out.print("Choose option between " + 0 + " and " + 3 + ": ");
//            try {
//                input = scanner.nextInt();
//                if (input >= 0 && input <= 3) {
//                    isValid = true;
//                } else {
//                    System.out.println("Input is out of range.");
//                }
//            } catch (Exception e) {
//                System.out.println("Invalid input. Please enter an integer.");
//                scanner.nextLine();
//            }
//        }
//
//        switch (input) {
//            case 1 -> findStationByID();
//            case 2 -> showStations();
//            case 3 -> createStation();
//            case 0 -> showMain();
//        }
//    }
//
//    private void createStation() {
//        System.out.println("--------------------------------\n" +
//                "\t Create Station \n" +
//                "\t Write down the new station name\n" +
//                "\t or choose 0 to get back to Main Menu\n" +
//                "--------------------------------\n");
//
//        String input = "";
//
//        while (input.isEmpty() || !input.matches("[a-zA-Z' 0]+")) {
//            try {
//                System.out.println("Write down city name: ");
//                input = scanner.nextLine().trim();
//            } catch (Exception e) {
//                System.out.println("Incorrect input.");
//            }
//        }
//
//        if (input.equals("0")) {
//            showMain();
//        } else {
//            if(isNew(input)) {
//                RailwayStation station = new RailwayStation(input);
//                System.out.println(station);
//            } else {
//                System.out.println("Station already exists.");
//            }
//        }
//        createStation();
//    }
//
//    private boolean isNew(String input) {
//        Optional<RailwayStation> optionalRailwayStation = RailwayStation.getStations().stream()
//                .filter(station -> station.getName().equals(input)).findFirst();
//        if (optionalRailwayStation.isPresent()) {
//            System.out.println(optionalRailwayStation);
//            return false;
//        }
//        return true;
//    }
//
//    private void showStations() {
//        System.out.println("--------------------------------\n" +
//                "\t LIST OF STATIONS \n" +
//                "--------------------------------\n");
//        for (RailwayStation station : RailwayStation.getStations()) {
//            System.out.println(station);
//        }
//
//        stationsMenu();
//    }
//
//    private void findStationByID() {
//        int max = RailwayStation.getStations().size();
//        System.out.println("--------------------------------\n" +
//                "\t FIND STATION BY ID\n" +
//                "\t Write down the ID number of a chosen Station \n" +
//                "\t or choose 0 to get back to Main Menu\n" +
//                "--------------------------------\n");
//        int input = -1;
//        boolean isValid = false;
//        while (!isValid) {
//            System.out.print("Choose option between " + 0 + " and " + max + ": ");
//            try {
//                input = scanner.nextInt();
//                if (input >= 0 && input <= max) {
//                    isValid = true;
//                } else {
//                    System.out.println("Input is out of range.");
//                }
//            } catch (Exception e) {
//                System.out.println("Invalid input. Please enter an integer.");
//                scanner.nextLine();
//            }
//        }
//        if (input == 0) {
//            showMain();
//        } else {
//            RailwayStation station = findStation(input);
//            if (station != null) {
//                System.out.println(station);
//            }
//            findStationByID();
//        }
//    }
//
//    public void connectionsMenu() {
//        System.out.println("--------------------------------\n" +
//                "\t Connections\n" +
//                "\t choose desired option by writing down its number \n" +
//                "--------------------------------\n" +
//                "\t1. Show existing connections\n" +
//                "\t2. Create a new connection\n" +
//                "\t0. Get back to Main Menu\n");
//        int input = -1;
//        boolean isValid = false;
//        while (!isValid) {
//            System.out.print("Choose option between " + 0 + " and " + 2 + ": ");
//            try {
//                input = scanner.nextInt();
//                if (input >= 0 && input <= 2) {
//                    isValid = true;
//                } else {
//                    System.out.println("Input is out of range.");
//                }
//            } catch (Exception e) {
//                System.out.println("Invalid input. Please enter an integer.");
//                scanner.nextLine();
//            }
//        }
//
//        switch (input) {
//            case 1 -> showConnections();
//            case 2 -> createConnection();
//            case 0 -> showMain();
//        }
//    }
//
//    private void createConnection() {
//        int max = RailwayStation.getStations().size();
//        System.out.println("--------------------------------\n" +
//                "\t Create Connection \n" +
//                "\t Write down the new connection data\n" +
//                "\t or choose 0 to get back to Main Menu\n" +
//                "--------------------------------\n");
//
//        int stat1 = -1;
//        boolean isValid = false;
//        while (!isValid) {
//            System.out.print("Write down source station's id.\n");
//            System.out.print("Choose id between " + 1 + " and " + max + ": ");
//            try {
//                stat1 = scanner.nextInt();
//                if (stat1 == 0) {
//                    connectionsMenu();
//                    break;
//                }
//                if (stat1 >= 1 && stat1 <= max) {
//                    isValid = true;
//                } else {
//                    System.out.println("Input is out of range.");
//                }
//            } catch (Exception e) {
//                System.out.println("Invalid input. Please enter an integer.");
//                scanner.nextLine();
//            }
//        }
//        int stat2 = -1;
//        isValid = false;
//        while (!isValid) {
//            System.out.print("Write down final station's id.");
//            System.out.print("Choose id between " + 1 + " and " + max + ": ");
//            try {
//                stat2 = scanner.nextInt();
//                if (stat2 == 0) {
//                    connectionsMenu();
//                    break;
//                }
//                if (stat1 == stat2) {
//                    System.out.println("Final Station's id should be different from source station's id.");
//                }
//                else if (stat2 >= 0 && stat2 <= max) {
//                    isValid = true;
//                } else {
//                    System.out.println("Input is out of range.");
//                }
//            } catch (Exception e) {
//                System.out.println("Invalid input. Please enter an integer.");
//                scanner.nextLine();
//            }
//        }
//        int distance = -1;
//        isValid = false;
//        while (!isValid) {
//            System.out.print("Write down the distance between stations in km: ");
//            try {
//                distance = scanner.nextInt();
//                if (distance == 0) {
//                    connectionsMenu();
//                    break;
//                }
//                if (distance > 0) {
//                    isValid = true;
//                } else {
//                    System.out.println("Distance can't be below 0.");
//                }
//            } catch (Exception e) {
//                System.out.println("Invalid input. Please enter an integer.");
//                scanner.nextLine();
//            }
//        }
//
//        RailwayStation sourceStat = findStation(stat1);
//        RailwayStation finalStat = findStation(stat2);
//
//        try {
//            RailwayConnection newConn = new RailwayConnection(sourceStat, finalStat, distance);
//            System.out.println(newConn);
//        } catch (Exception e) {
//            System.out.println(e + " Connection cannot be created.");
//        }
//
//        createConnection();
//    }
//
//    private void showConnections() {
//        System.out.println("--------------------------------\n" +
//                "\t LIST OF CONNECTIONS \n" +
//                "--------------------------------\n");
//        for (RailwayConnection con : RailwayConnection.getConnections()) {
//            System.out.println(con);
//        }
//
//        connectionsMenu();
//    }
//
//    public void trainsetsMenu() {
//        System.out.println("--------------------------------\n" +
//                "\t LOCOMOTIVES\n" +
//                "\t choose desired option by writing down its number \n" +
//                "--------------------------------\n" +
//                "\t1. Show active trainsets\n" +
//                "\t2. Show inactive trainsets\n" +
//                "\t3. Create new trainset\n" +
//                "\t0. Get back to Main Menu\n");
//
//        int input = -1;
//        boolean isValid = false;
//        while (!isValid) {
//            System.out.print("Choose option between " + 0 + " and " + 3 + ": ");
//            try {
//                input = scanner.nextInt();
//                if (input >= 0 && input <= 3) {
//                    isValid = true;
//                } else {
//                    System.out.println("Input is out of range.");
//                }
//            } catch (Exception e) {
//                System.out.println("Invalid input. Please enter an integer.");
//                scanner.nextLine();
//            }
//        }
//
//        switch (input) {
//            case 1 -> showActiveTrainSets();
//            case 2 -> showInactiveTrainSets();
//            case 3 -> createTrainset();
//            case 0 -> showMain();
//        }
//    }
//
//    private void createTrainset() {
//        int max = RailwayStation.getStations().size();
//        int maxLoc = Locomotive.getLocomotives().size();
//        System.out.println("--------------------------------\n" +
//                "\t CREATE TRAINSET \n" +
//                "\t Write down the new trainset data\n" +
//                "\t or choose 0 to get back to Main Menu\n" +
//                "--------------------------------\n");
//
//        int loc = -1;
//        Locomotive locObj = null;
//        boolean isValid = false;
//        while (!isValid) {
//            System.out.print("Write down available locomotive's id.\n");
//            System.out.print("Choose id between " + 1 + " and " + maxLoc + ": ");
//            try {
//                loc = scanner.nextInt();
//                if (loc == 0) {
//                    trainsetsMenu();
//                    break;
//                }
//                if (loc >= 1 && loc <= maxLoc) {
//                    locObj = findLocomotive(loc);
//                    if (locObj == null) {
//                        continue;
//                    } else if (!locObj.isAvailable) {
//                        System.out.println("Chosen locomotive is not available. Choose again.");
//                    } else
//                        isValid = true;
//                } else {
//                    System.out.println("Input is out of range.");
//                }
//            } catch (Exception e) {
//                System.out.println("Invalid input. Please enter an integer.");
//                scanner.nextLine();
//            }
//        }
//
//        int stat1 = -1;
//        isValid = false;
//        while (!isValid) {
//            System.out.print("Write down source station's id.\n");
//            System.out.print("Choose id between " + 1 + " and " + max + ": ");
//            try {
//                stat1 = scanner.nextInt();
//                if (stat1 == 0) {
//                    trainsetsMenu();
//                    break;
//                }
//                if (stat1 >= 1 && stat1 <= max) {
//                    isValid = true;
//                } else {
//                    System.out.println("Input is out of range.");
//                }
//            } catch (Exception e) {
//                System.out.println("Invalid input. Please enter an integer.");
//                scanner.nextLine();
//            }
//        }
//        int stat2 = -1;
//        isValid = false;
//        while (!isValid) {
//            System.out.print("Write down final station's id.");
//            System.out.print("Choose id between " + 1 + " and " + max + ": ");
//            try {
//                stat2 = scanner.nextInt();
//                if (stat2 == 0) {
//                    trainsetsMenu();
//                    break;
//                }
//                if (stat1 == stat2) {
//                    System.out.println("Final Station's id should be different from source station's id.");
//                }
//                else if (stat2 >= 0 && stat2 <= max) {
//                    isValid = true;
//                } else {
//                    System.out.println("Input is out of range.");
//                }
//            } catch (Exception e) {
//                System.out.println("Invalid input. Please enter an integer.");
//                scanner.nextLine();
//            }
//        }
//
//        try {
//            RailwayStation sourceStat = findStation(stat1);
//            RailwayStation finalStat = findStation(stat2);
//            TrainSet set = new TrainSet(locObj);
//            set.setSourceStation(sourceStat);
//            set.setDestinationStation(finalStat);
//            set.startTrainSet();
//            System.out.println(set);
//        } catch (Exception e) {
//            System.out.println(e + " Trainset cannot be created.");
//        }
//
//        createTrainset();
//    }
//
//    private void showInactiveTrainSets() {
//        System.out.println("--------------------------------\n" +
//                "\t LIST OF INACTIVE TRAINSETS \n" +
//                "--------------------------------\n");
//        for (TrainSet set : TrainSet.getTrainsets()) {
//            if (!set.isActive()) {
//                System.out.println(set);
//            }
//        }
//        trainsetsMenu();
//    }
//
//    private void showActiveTrainSets() {
//        System.out.println("--------------------------------\n" +
//                "\t LIST OF ACTIVE TRAINSETS \n" +
//                "--------------------------------\n");
//        for (TrainSet set : TrainSet.getTrainsets()) {
//            if (set.isActive()) {
//                System.out.println(set);
//            }
//        }
//        trainsetsMenu();
//    }
//
//    public void generateReportMenu() {
//        int max = TrainSet.getTrainsets().size();
//        System.out.println("--------------------------------\n" +
//                "\t GENERATE A RAPORT\n" +
//                "\t To generate a raport write down the ID number of a chosen TrainSet \n" +
//                "\t or choose 0 to get back to Main Menu\n" +
//                "--------------------------------\n");
//        int input = -1;
//        boolean isValid = false;
//        while (!isValid) {
//            System.out.print("Choose option between " + 0 + " and " + max + ": ");
//            try {
//                input = scanner.nextInt();
//                if (input >= 0 && input <= max) {
//                    isValid = true;
//                } else {
//                    System.out.println("Input is out of range.");
//                }
//            } catch (Exception e) {
//                System.out.println("Invalid input. Please enter an integer.");
//                scanner.nextLine();
//            }
//        }
//        if (input == 0) {
//            showMain();
//        } else {
//            TrainSet set = findTrainset(input);
//            if (set != null) {
//                new Report(set);
//            }
//            generateReportMenu();
//        }
//    }
//
//    public static TrainSet findTrainset(Integer id) {
//        Optional<TrainSet> optionalTrainSet = TrainSet.getTrainsets().stream()
//                .filter(station -> station.getId() == id).findFirst();
//        if (optionalTrainSet.isPresent()) {
//            return optionalTrainSet.get();
//        } else {
//            System.out.println("No Trainset with id: " + id + "\n");
//            return null;
//        }
//    }
//
//    public static RailwayStation findStation(Integer id) {
//        Optional<RailwayStation> optionalRailwayStation = RailwayStation.getStations().stream()
//                .filter(station -> station.getId() == id).findFirst();
//        if (optionalRailwayStation.isPresent()) {
//            return optionalRailwayStation.get();
//        } else {
//            System.out.println("No Station with id: " + id + "\n");
//            return null;
//        }
//    }
//
//    public static Locomotive findLocomotive(Integer id) {
//        Optional<Locomotive> optionalLocomotive = Locomotive.getLocomotives().stream()
//                .filter(loc -> loc.getId() == id).findFirst();
//        if (optionalLocomotive.isPresent()) {
//            return optionalLocomotive.get();
//        } else {
//            System.out.println("No Locomotive with id: " + id + "\n");
//            return null;
//        }
//    }
//    public static RailroadCar findCar(Integer id) {
//        Optional<RailroadCar> optionalCar = RailroadCar.getCars().stream()
//                .filter(car -> car.getId() == id).findFirst();
//        if (optionalCar.isPresent()) {
//            return optionalCar.get();
//        } else {
//            System.out.println("No Railroad Car with id: " + id + "\n");
//            return null;
//        }
//    }


    @Override
    public void run() {
        try {
            showMain();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
