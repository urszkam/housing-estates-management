package rents;

import estate.Rooms.Apartment;
import estate.Rooms.ParkingPlace;
import estate.Rooms.Room;
import estate.Rooms.RoomType;
import tenants.Person;
import tenants.TenantLetter;
import exceptions.ProblematicTenantException;
import util.Calendar;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Rent implements Runnable{
    private static int nextId = 1;
    private static List<Rent> rents = new ArrayList<>();
    private int id;
    private boolean isEnded;
    private Person tenant;
    private String startDate;
    private String endDate;
    private TenantLetter letter;
    private Room room;
    private Thread rentThread;

    public Rent(Person tenant, String startDate, String endDate, Room room) {
        this.tenant = tenant;
        this.startDate = startDate;
        this.endDate = endDate;
        this.room = room;
        this.isEnded = false;
        this.letter = null;
        this.start();
    }

    public static List<Rent> getRents() {
        return rents;
    }

    public int getId() {
        return id;
    }

    public boolean isEnded() {
        return isEnded;
    }

    public TenantLetter getLetter() {
        return letter;
    }

    public void setLetter(TenantLetter letter) {
        this.letter = letter;
    }

    public void setEnded(boolean ended) {
        isEnded = ended;
    }

    public Person getTenant() {
        return tenant;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setEndDate(String date) {
        this.endDate = date;
    }

    public String getEndDate() {
        return endDate;
    }

    public Room getRoom() {
        return room;
    }

    public static Rent getById(int id) {
        return rents.stream()
                .filter(item -> item.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void endRent() {
        setEnded(true);
        this.letter = new TenantLetter(tenant, startDate, endDate, room);
        tenant.addLetter(letter);
        System.out.println("\n*rents.Rent ended for apartment: " + room.getId() + "*\n");
    }

    public void finalTerminate() {
        if (this.getRoom().getRoomType() == RoomType.APARTMENT) {
            Apartment apt = (Apartment) this.getRoom();
            apt.checkOutAll();
        } else {
            ParkingPlace pp = (ParkingPlace) this.getRoom();
            pp.takeOutAll();
        }
        this.getRoom().setRent(false);
        this.getRoom().setResponsibleForFees(null);
    }

    public void prolongRent(String date) {
        setEndDate(date);
        setEnded(false);
        if (tenant.getLetters().contains(letter)) {
            tenant.getLetters().remove(letter);
        }
    }


    private void start() {
        boolean isStarted = room.startNewRent(tenant);
        if (isStarted) {
            this.id = nextId++;
            rents.add(this);
            this.rentThread = new Thread(this);
            this.rentThread.setDaemon(true);
            rentThread.start();
        }
    }

    public boolean checkDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate end = LocalDate.parse(endDate, formatter);
        LocalDate today = LocalDate.parse(util.Calendar.getToday(), formatter);
        return today.isAfter(end);
    }

    public boolean check30DaysAfter() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate end = LocalDate.parse(endDate, formatter);
        LocalDate today = LocalDate.parse(Calendar.getToday(), formatter);
        return today.isAfter(end.plusDays(30));
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
            if (!isEnded && checkDate()) {
                endRent();
                try {
                    tenant.checkNumOfLetters();
                } catch (ProblematicTenantException e) {
                    System.out.println("\n*" + e + "*\n");
                }
            }
            if (isEnded && check30DaysAfter()) {
                finalTerminate();
                exit = true;
            }
        }

    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder()
                .append("rents.Rent ID: ").append(id)
                .append(", start date: ").append(startDate)
                .append(", end date: ").append(endDate)
                .append(", person responsible for fees: ").append(tenant);
        return str.toString();
    }
}