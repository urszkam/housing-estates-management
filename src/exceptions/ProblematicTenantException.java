package exceptions;

import tenants.Person;

public class ProblematicTenantException extends Exception{

    public ProblematicTenantException(Person tenant) {
        super("\n*Tenants.Person " + tenant.getFullName() + " had already renting rooms: " + tenant.getRooms() + "*\n");
    }

}
