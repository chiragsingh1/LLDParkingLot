package lld.parkinglot.enums;

public enum VehicleType {
    TWO_WHEELER("Two_Wheeler"),
    THREE_WHEELER("Three_Wheeler"),
    FOUR_WHEELER("Four_Wheeler");

    private final String value;

    private VehicleType(String value){
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }

}
