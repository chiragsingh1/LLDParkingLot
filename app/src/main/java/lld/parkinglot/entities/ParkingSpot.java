package lld.parkinglot.entities;

import lld.parkinglot.enums.VehicleType;

public interface ParkingSpot {
    public boolean isEmpty();
    public void occupy();
    public void vacate();
    public VehicleType getParkingType();
    public String getId();
    public int getPrice();
}
