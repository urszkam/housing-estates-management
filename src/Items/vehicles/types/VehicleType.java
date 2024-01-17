package Items.vehicles.types;

public enum VehicleType {
    AMPHIBIOUS("maxLandSpeed", "^\\d+(\\.\\d+)?$"),
    BOAT("boatType", ""),
    CITY_CAR("parkingAssist", "^(?i)true|false$"),
    MOTORCYCLE("seatHeight", "^\\d+(\\.\\d+)?$"),
    OFF_ROAD_CAR("groundClearance", "^\\d+(\\.\\d+)?$");


    private String specificField;
    private String pattern;

    VehicleType(String field, String pattern) {
        this.specificField = field;
        this.pattern = pattern;
    }

    public String getSpecificField() {
        return specificField;
    }

    public String getPattern() {
        return pattern;
    }
}
