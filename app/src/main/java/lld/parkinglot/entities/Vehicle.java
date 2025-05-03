package lld.parkinglot.entities;

import lld.parkinglot.enums.VehicleType;

public class Vehicle {
    private final String licensePlate;
    private final VehicleType type;

    public Vehicle(String licensePlate, VehicleType type) {
        this.licensePlate = licensePlate;
        this.type = type;
    }

    public VehicleType getVehicleType(){
        return this.type;
    }
    public String getLicensePlate(){
        return this.licensePlate;
    }

}
