public class ProblematicTenantException extends Exception{

    public ProblematicTenantException(Person tenant) {
        super("Person " + tenant.getFullName() + " had already renting rooms: " + tenant.getRooms());
    }

}
