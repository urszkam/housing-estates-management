package tenants;

import estate.Rooms.Room;
import util.Calendar;

public class TenantLetter {
    private Person tenant;
    private String startDate;
    private String endDate;
    private Room room;
    private String content;

    public TenantLetter(Person tenant, String startDate, String endDate, Room room) {
        this.tenant = tenant;
        this.startDate = startDate;
        this.endDate = endDate;
        this.room = room;
        this.content = createLetter();
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

    public Room getRoom() {
        return room;
    }

    public String getContent() {
        return content;
    }

    private String createLetter() {
        StringBuilder str = new StringBuilder()
                .append(Calendar.getToday()).append("\n")
                .append(tenant.getFullName()).append("\n").append(tenant.getAddress()).append("\n\n")
                .append("Subject: Lease Termination Confirmation\n\n")
                .append("Dear ").append(tenant.getFullName()).append(",\n")
                .append("I hereby confirm the termination of the lease agreement\n")
                .append("for the property located at [Property Address].\n")
                .append("Thank you for your tenancy.\n\n")
                .append("Sincerely,\n")
                .append("XYZ\n");
        return str.toString();
    }
}
