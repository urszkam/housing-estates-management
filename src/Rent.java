import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Rent implements Runnable{
    private static int nextId = 1;
    private static List<Rent> rents = new ArrayList<>();
    private int id;
    private Person tenant;
    private String startDate;
    private String endDate;
    private Apartment apartment;
    private ParkingPlace parking;
    private Thread rentThread;

    public Rent(Person tenant, String startDate, String endDate, Apartment apartment) {
        this.tenant = tenant;
        this.startDate = startDate;
        this.endDate = endDate;
        this.apartment = apartment;
        this.parking = null;
        this.start();
    }

    public Rent(Person tenant, String startDate, String endDate, Apartment apartment, ParkingPlace parking) {
        this.tenant = tenant;
        this.startDate = startDate;
        this.endDate = endDate;
        this.apartment = apartment;
        this.parking = parking;
        this.start();
    }

    public static List<Rent> getRents() {
        return rents;
    }

    public int getId() {
        return id;
    }

    public Person getTenant() {
        return tenant;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public Apartment getApartment() {
        return apartment;
    }

    public ParkingPlace getParking() {
        return parking;
    }

    private void endRent() {
        TenantLetter letter = new TenantLetter(tenant, startDate, endDate, apartment);
        tenant.addLetter(letter);
        System.out.println(letter.getContent());
    }

    private void start() {
        boolean isStarted = apartment.startNewRent(tenant);
        if (parking != null) parking.startNewRent(tenant);
        if (isStarted) {
            this.id = nextId++;
            rents.add(this);
            this.rentThread = new Thread(this);
            this.rentThread.setDaemon(true);
            rentThread.start();
        }
    }

    private boolean checkDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate end = LocalDate.parse(endDate, formatter);
        LocalDate today = LocalDate.parse(Calendar.getToday(), formatter);
        return today.isAfter(end);
    }

    public static boolean checkDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate end = LocalDate.parse(date, formatter);
        LocalDate today = LocalDate.parse(Calendar.getToday(), formatter);
        return today.isAfter(end);
    }

    @Override
    public void run() {
        boolean exit = false;
        while (!exit) {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (checkDate()) {
                endRent();
                try {
                    tenant.checkNumOfLetters();
                } catch (ProblematicTenantException e) {
                    System.out.println(e);
                }
                exit = true;
            }
        }

    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder()
                .append("Rent ID: ").append(id)
                .append(", start date: ").append(startDate)
                .append(", end date: ").append(endDate)
                .append(", person responsible for fees: ").append(tenant);
        return str.toString();
    }
}
