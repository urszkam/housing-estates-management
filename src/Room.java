import java.util.ArrayList;
import java.util.List;

public abstract class Room {
    private boolean isRented;
    private int id;
    private double volume;
    private HousingEstate housingEstate;
    private Person responsibleForFees;

    public Room(int id, double volume) {
        this.isRented = false;
        this.id = id;
        this.volume = volume;
        this.housingEstate = null;
        this.responsibleForFees = null;
    }

    public Room(int id, double length, double width, double height) {
        this.isRented = false;
        this.id = id;
        this.volume = this.calculateVolume(length, width, height);
        this.housingEstate = null;
        this.responsibleForFees = null;
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

    public void setHousingEstate(HousingEstate estate) {
        this.housingEstate = estate;
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

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder()
                .append("ID: ").append(id).append(",")
                .append(" volume: ").append(volume);
//        if (itemsIn.size() > 0) {
//            str.append(" Item(s) stored in:\n");
//            for (Item item : itemsIn)
//                str.append("\t" + item + "\n");
//        } else str.append(" No items stored inside.\n");
//        if (isRented) {
//            str.append(" Tenants:\n");
//            for (Person tenant : tenants)
//                str.append("\t" + tenant + "\n");
//        } else str.append(" Nobody rents this " + getClass().getSimpleName().toLowerCase() + ".\n");
        return str.toString();
    }
}
